package com.example.pilusapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var editTextEmail : EditText
    private lateinit var editTextPassword : EditText
    private lateinit var buttonLogin : Button
    private lateinit var buttonRegister : Button
    private lateinit var buttonResetPassword : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    init()
    registerListeners()
    }
    private fun init(){
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        buttonRegister = findViewById(R.id.buttonRegister)
        buttonResetPassword = findViewById(R.id.buttonResetPassword)
    }

    private fun registerListeners(){
        buttonRegister.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
        buttonResetPassword.setOnClickListener {
            startActivity(Intent(this, PasswordResetActivity::class.java))
        }
        buttonLogin.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            if(email.isEmpty()or password.isEmpty()){
                Toast.makeText(this,"შეიყვანეთ თქვენი E-mail და პაროლი",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email,password)
                .addOnCompleteListener {    task ->
                if(task.isSuccessful){
                gotoProfile()
                }
                else{
                Toast.makeText(this,"შეყვანილი პაროლი ან E-mail არასწორია ",Toast.LENGTH_SHORT).show()
                }}
            }
    }

        private fun gotoProfile(){
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }
}
