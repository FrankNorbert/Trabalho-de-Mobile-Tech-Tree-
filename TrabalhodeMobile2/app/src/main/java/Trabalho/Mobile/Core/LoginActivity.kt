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
    private lateinit var goToRegisterButton: Button

    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.login_email_input)
        password = findViewById(R.id.login_password_input)
        loginButton = findViewById(R.id.login_button)
        goToRegisterButton = findViewById(R.id.login_register_button)

        auth = FirebaseAuth.getInstance()

        loginButton.setOnClickListener{
            var txt_email : String = email.text.toString()
            var txt_password : String = password.text.toString()

            loginUser(txt_email, txt_password)
        }

        goToRegisterButton.setOnClickListener{
            Toast.makeText(this, "A new soldier will join so", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@LoginActivity,RegisterActivity::class.java))
            finish()
        }
    }

    private fun loginUser(txtEmail: String, txtPassword: String) {

        auth.signInWithEmailAndPassword(txtEmail,txtPassword).addOnCompleteListener{
            if(it.isSuccessful){
                Toast.makeText(this, "Login feito com sucesso!", Toast.LENGTH_SHORT).show()
                val intentToMain = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intentToMain)
            } else{
                Toast.makeText(this@LoginActivity,"Falha no login, ou a senha ou o e-mail estão incorretos",Toast.LENGTH_SHORT).show()
            }

        }

    }

    override fun onStart() {
        super.onStart()

        if(auth.currentUser != null){
            val intentToMain = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intentToMain)
        }
    }
}