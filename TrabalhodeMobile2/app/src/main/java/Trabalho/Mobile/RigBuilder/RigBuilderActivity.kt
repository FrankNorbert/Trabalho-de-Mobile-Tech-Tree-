package Trabalho.Mobile.RigBuilder

import Trabalho.Mobile.R
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.UUID

class RigBuilderActivity : AppCompatActivity() {

    lateinit var botaoAddPc: Button
    lateinit var pcName:EditText
    lateinit var infoButton:FloatingActionButton
    lateinit var pcListView: ListView

    var pc = arrayListOf<PC>()

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

            val computer = PC(UUID.randomUUID().toString(),pcName.text.toString())

            db.collection("users").document(userId).collection("PC").add(computer.toHashmapPC()).addOnSuccessListener { task->
                Log.d(TAG, "DocumentSnapshot added with ID: ${task.id}")
            }.addOnFailureListener{ e->
                Log.w(TAG,"Error Adding PC",e)
            }
        }

    }
}