package Trabalho.Mobile.Core


import Trabalho.Mobile.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StartActivity : AppCompatActivity() {

    private lateinit var botaoLogin : Button
    private lateinit var botaoRegister: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        botaoLogin = findViewById<Button>(R.id.button_login)
        botaoRegister = findViewById<Button>(R.id.button_register)

        botaoRegister.setOnClickListener{
            val intent = Intent(this@StartActivity, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        botaoLogin.setOnClickListener{
            val loginIntent = Intent(this@StartActivity, LoginActivity::class.java)
            startActivity(loginIntent)
            finish()
        }

        /*
        botaoLogin.setOnClickListener{
            setContentView(R.layout.login_screen)
        }
        */
    }
}