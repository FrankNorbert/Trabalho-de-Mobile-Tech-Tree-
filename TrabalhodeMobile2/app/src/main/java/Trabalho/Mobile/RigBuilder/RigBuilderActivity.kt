package Trabalho.Mobile.RigBuilder

import Trabalho.Mobile.R
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import java.util.UUID

class RigBuilderActivity : AppCompatActivity() {

    lateinit var botaoAddPc: FloatingActionButton
    lateinit var pcName:EditText
    lateinit var infoButton:FloatingActionButton
    lateinit var pcListView: ListView

    companion object{
        const val TAG = "RigBuilderActivity"

    }

    var pc = arrayListOf<PC>()

    val pcAdapter = PcAdapter()

    val db = Firebase.firestore
    val userId = FirebaseAuth.getInstance().currentUser!!.uid

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rig_builder)
        botaoAddPc = findViewById(R.id.rig_builder_button_add_pc)
        pcName = findViewById(R.id.rig_builder_text_input)
        infoButton = findViewById(R.id.rig_builder_button_info)
        pcListView = findViewById(R.id.rig_builder_pc_list)


        botaoAddPc.setOnClickListener{

            var pc_text :String = pcName.text.toString()
            val computer = PC(UUID.randomUUID().toString(),pc_text)

            db.collection("users").document(userId).collection("PC").add(computer.toHashmapPC()).addOnSuccessListener { task->
                Log.d(TAG, "DocumentSnapshot added with ID: ${task.id}")
                Toast.makeText(this,"Pc added",Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{ e->
                Log.w(TAG,"Error Adding PC",e)
                Toast.makeText(this,"Sorry link, i can't give credit, come back when\n you're a little hmmm richer",Toast.LENGTH_SHORT).show()
            }
        }
        pcListView.adapter = pcAdapter


        db.collection("users").document(userId).collection("PC").addSnapshotListener{ value, e->

            if (e!=null){
                Log.w(TAG,"Listen failed.",e)
                return@addSnapshotListener
            }

            pc.clear()
            for (doc in value!!){
                val pc = PC.fromQueryDoc(doc)
                this.pc.add(pc)
            }

            pcAdapter.notifyDataSetChanged()
        }

    }

    fun getPcName():String{
        return pcName.toString()
    }

    inner class PcAdapter : BaseAdapter() {

        override fun getCount(): Int {
            return pc.size
        }

        override fun getItem(p0: Int): Any {
            return pc[p0]
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val rootView = layoutInflater.inflate(R.layout.pc_item_layout, p2,false )
            val textViewPcName = rootView.findViewById<TextView>(R.id.pc_name)
            val editButton = rootView.findViewById<ImageButton>(R.id.pc_edit_button)
            val deleteButton = rootView.findViewById<FloatingActionButton>(R.id.pc_delete_button)

            textViewPcName.text = pc[p0].counter.toString()

            deleteButton.setOnClickListener{

                var pcId = db.collection("users").document(userId).collection("PC").document().id

                db.collection("users").document(userId).collection("PC").document(pcId).delete().addOnSuccessListener {
                    Log.d(TAG,"Pc deleted with success")
                    Toast.makeText(this@RigBuilderActivity,"YOU KILLED IT",Toast.LENGTH_SHORT).show()
                }.addOnFailureListener{
                    Toast.makeText(this@RigBuilderActivity,"Failed to delete the pc",Toast.LENGTH_SHORT).show()
                }

                db.collection("users").document(userId).collection("PC").addSnapshotListener{ value, e->

                    if (e!=null){
                        Log.w(TAG,"Listen failed.",e)
                        return@addSnapshotListener
                    }

                    pc.clear()
                    for (doc in value!!){
                        val pcThing = PC.fromQueryDoc(doc)
                        pc.remove(pcThing)
                    }

                    pcAdapter.notifyDataSetChanged()
                }

            }

            editButton.setOnClickListener{

            }

            textViewPcName.text = pc[p0].name
            return rootView
        }
    }
}