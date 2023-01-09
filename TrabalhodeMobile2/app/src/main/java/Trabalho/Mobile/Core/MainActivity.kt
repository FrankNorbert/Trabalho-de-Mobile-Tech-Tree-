package Trabalho.Mobile.Core


import Trabalho.Mobile.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    //Botões colocados em static context
    companion object{
        internal lateinit var botaoLogin : Button
        internal lateinit var botaoRegister: Button
        internal lateinit var botaoLogout : Button
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        botaoLogin = findViewById<Button>(R.id.button_login)
        botaoRegister = findViewById<Button>(R.id.button_register)
        botaoLogout = findViewById<Button>(R.id.button_logout)

        botaoRegister.setOnClickListener{
            val registerIntent = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(registerIntent)
            finish()
        }

        botaoLogin.setOnClickListener{
            val loginIntent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(loginIntent)
            finish()
        }

        botaoLogout.setOnClickListener{

        }

        /*
        botaoLogin.setOnClickListener{
            setContentView(R.layout.login_screen)
        }
        */
    }
}