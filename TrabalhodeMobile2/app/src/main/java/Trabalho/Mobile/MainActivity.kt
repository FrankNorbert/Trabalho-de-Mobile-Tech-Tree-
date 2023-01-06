package Trabalho.Mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var botaoLogin = findViewById<Button>(R.id.button_login)
        botaoLogin.setOnClickListener{
            setContentView(R.layout.login_screen)
        }
    }

    fun loadButtons(){

    }

    fun loadAnotherThings(){

    }
}