package Trabalho.Mobile.Core


import Trabalho.Mobile.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    //Botões colocados em static context
    companion object{
        internal lateinit var botaoLogout : Button
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botaoLogout = findViewById<Button>(R.id.button_logout)

        botaoLogout.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            Toast.makeText(this,"You will touch some grass", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@MainActivity,LoginActivity::class.java))
        }

        /*
        botaoLogin.setOnClickListener{
            setContentView(R.layout.login_screen)
        }
        */
    }
}