package Trabalho.Mobile.Core

import Trabalho.Mobile.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.util.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        email = findViewById(R.id.register_email_input)
        password = findViewById(R.id.register_password_input)
        registerButton = findViewById(R.id.register_button)

        registerButton.setOnClickListener{
            var txt_email : String = email.text.toString()
        }
    }
}