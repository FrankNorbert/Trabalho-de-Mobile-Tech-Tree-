package Trabalho.Mobile.RigBuilder

import Trabalho.Mobile.R
import Trabalho.Mobile.RigBuilder.SubActivities.PcEditActivity
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
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
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
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

                db.collection("users")
                    .document(userId)
                    .collection("PC")
                    .whereEqualTo("name",pc[p0].name)
                    .get().addOnCompleteListener{ task ->

                        if(task.isSuccessful && !task.getResult().isEmpty){
                            var documentSnapshot : DocumentSnapshot = task.getResult().documents.get(0)
                            var documentName :String = documentSnapshot.id
                            db.collection("users")
                                .document(userId)
                                .collection("PC")
                                .document(documentName)
                                .delete()
                                .addOnSuccessListener {
                                    Toast.makeText(this@RigBuilderActivity,"Pc deleted",Toast.LENGTH_SHORT).show()
                                    Log.d(TAG,"Successfully deleted")
                                }.addOnFailureListener {
                                    Toast.makeText(this@RigBuilderActivity,"Something has ocurred",Toast.LENGTH_SHORT).show()
                                    Log.w(TAG,"Could not delete the pc")
                                }
                        }else{
                            Toast.makeText(this@RigBuilderActivity,"Could not delete the pc",Toast.LENGTH_SHORT).show()
                        }
                    }
            }

            editButton.setOnClickListener{
                Toast.makeText(this@RigBuilderActivity,"Make it big and stronger",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@RigBuilderActivity,PcEditActivity::class.java))
            }

            textViewPcName.text = pc[p0].name
            return rootView
        }
    }
}