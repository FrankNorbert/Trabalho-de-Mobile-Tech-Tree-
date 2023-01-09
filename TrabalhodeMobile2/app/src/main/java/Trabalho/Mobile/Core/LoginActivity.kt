package Trabalho.Mobile.Core

import Trabalho.Mobile.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var email :EditText
    private lateinit var password:EditText
    private lateinit var loginButton :Button
    private lateinit var returnButton :ImageView

    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.login_email_input)
        password = findViewById(R.id.login_password_input)
        loginButton = findViewById(R.id.login_button)
        returnButton = findViewById(R.id.login_Return_Button)

        auth = FirebaseAuth.getInstance()

        returnButton.setOnClickListener{
            Toast.makeText(this,"Voltando ao início",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@LoginActivity,MainActivity::class.java))
            finish()
        }

        loginButton.setOnClickListener{
            var txt_email : String = email.text.toString()
            var txt_password : String = password.text.toString()

            loginUser(txt_email, txt_password)
        }
    }

    private fun loginUser(txtEmail: String, txtPassword: String) {

        auth.signInWithEmailAndPassword(txtEmail,txtPassword).addOnCompleteListener(this){ task ->
            if (task.isSuccessful){
                Toast.makeText(this, "Login feito com sucesso!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                MainActivity.botaoLogin.visibility = View.GONE
                MainActivity.botaoRegister.visibility = View.GONE
                MainActivity.botaoLogout.visibility = View.VISIBLE
                finish()
            } else{
                Toast.makeText(this@LoginActivity,"Falha no login, ou a senha ou o e-mail estão incorretos",Toast.LENGTH_SHORT).show()
            }

        }

    }
}