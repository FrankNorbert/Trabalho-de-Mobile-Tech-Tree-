package Trabalho.Mobile.Core


import Trabalho.Mobile.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var botaoLogin : Button
    private lateinit var botaoRegister: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        botaoLogin = findViewById<Button>(R.id.button_login)
        botaoRegister = findViewById<Button>(R.id.button_register)

        botaoRegister.setOnClickListener{
            val intent = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        botaoLogin.setOnClickListener{
            val loginIntent = Intent(this@MainActivity, LoginActivity::class.java)
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