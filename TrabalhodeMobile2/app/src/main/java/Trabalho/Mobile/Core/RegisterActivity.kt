package Trabalho.Mobile.Core

import Trabalho.Mobile.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var registerButton: Button
    private lateinit var firebaseAuth : FirebaseAuth
    private lateinit var returnButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        email = findViewById(R.id.register_email_input)
        password = findViewById(R.id.register_password_input)
        registerButton = findViewById(R.id.register_button)
        returnButton = findViewById(R.id.register_return_button)

        firebaseAuth = FirebaseAuth.getInstance()

        returnButton.setOnClickListener{
            Toast.makeText(this,"Voltando ao início",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@RegisterActivity,MainActivity::class.java))
            finish()
        }

        registerButton.setOnClickListener{
            var txt_email : String = email.text.toString()
            var txt_password : String = password.text.toString()

            if(TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)){
                Toast.makeText(this, "Credenciais vazias", Toast.LENGTH_SHORT).show()
            } else if(txt_password.length < 5){
                Toast.makeText(this,"Tamanho de palavra-passe insuficiente",Toast.LENGTH_SHORT).show()
            }
            else{
                registerUser(txt_email,txt_password)
            }
        }
    }

    private fun registerUser(txtEmail: String, txtPassword: String) {
        firebaseAuth.createUserWithEmailAndPassword(txtEmail,txtPassword).addOnCompleteListener(this){ task->
            if(task.isSuccessful){
                Toast.makeText(this, "Registro feito com sucesso!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@RegisterActivity,MainActivity::class.java))
                //MainActivity.botaoRegister.visibility = View.INVISIBLE
                //MainActivity.botaoLogin.visibility = View.INVISIBLE
                //MainActivity.botaoLogout.visibility = View.VISIBLE
                finish()
            } else{
                Toast.makeText(this,"Falha no registro", Toast.LENGTH_SHORT).show()
            }
        }
    }
}