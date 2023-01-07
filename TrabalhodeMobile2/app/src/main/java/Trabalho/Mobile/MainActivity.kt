package Trabalho.Mobile


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var botaoLogin = findViewById<Button>(R.id.button_login)
        botaoLogin.setOnClickListener{
            setContentView(R.layout.login_screen)
            var textoEmail = findViewById<TextView>(R.id.login_email)
            var textoSenha = findViewById<TextView>(R.id.login_password)
            var botaoReturn = findViewById<ImageView>(R.id.login_Return_Button)
        }
    }
}