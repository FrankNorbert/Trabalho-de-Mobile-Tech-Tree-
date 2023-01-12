package Trabalho.Mobile.Core


import Trabalho.Mobile.PartPicker.PartPickerActivity
import Trabalho.Mobile.R
import Trabalho.Mobile.RigBuilder.RigBuilderActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    //Botões colocados em static context
    companion object{
        internal lateinit var botaoLogout : Button
        internal lateinit var botaoRigBuilder : Button
        internal lateinit var botaoPartPicker: Button
        internal lateinit var botaoInformacao: FloatingActionButton
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botaoLogout = findViewById<Button>(R.id.button_logout)
        botaoRigBuilder = findViewById(R.id.main_rig_builder_button)
        botaoPartPicker = findViewById(R.id.main_part_picker_button)
        botaoInformacao = findViewById(R.id.main_information_button)

        botaoRigBuilder.setOnClickListener{
            Toast.makeText(this,"Time to spend money?",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@MainActivity,RigBuilderActivity::class.java))
        }

        botaoInformacao.setOnClickListener{
            TODO("Ainda a implementar")
        }

        botaoPartPicker.setOnClickListener{
            Toast.makeText(this,"Are you searching for a new friend?",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@MainActivity,PartPickerActivity::class.java))
        }

        botaoLogout.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            Toast.makeText(this,"You will touch some grass", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@MainActivity,LoginActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menuInflater : MenuInflater = getMenuInflater()
        menuInflater.inflate(R.menu.main_activity_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.component_bookmark -> Toast.makeText(this@MainActivity,"Em implementação",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}