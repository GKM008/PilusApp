package com.example.pilusapp


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class RegistrationActivity : AppCompatActivity() {
    private lateinit var editTextEmail : EditText
    private lateinit var editTextPassword : EditText
    private lateinit var buttonRegister : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

    init()
    registerListeners()
    }

    private fun init(){
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonRegister = findViewById(R.id.buttonRegister)
    }
    private fun registerListeners(){
     buttonRegister.setOnClickListener {

         val email = editTextEmail.text.toString()
         val password = editTextPassword.text.toString()
         if(email.isEmpty()or password.isEmpty()){
             Toast.makeText(this,"შეიყვანეთ თქვენი E-mail და პაროლი", Toast.LENGTH_SHORT).show()
             return@setOnClickListener}

         if(email.isNotEmpty() or password.isNotEmpty()){
         FirebaseAuth.getInstance()
             .createUserWithEmailAndPassword(email,password)
             .addOnCompleteListener {task ->
                 if(task.isSuccessful){
                 startActivity(Intent(this,LoginActivity::class.java))
                 finish()
                 Toast.makeText(this,"რეგისტრაცია წარმატებით დასრულდა", Toast.LENGTH_LONG).show()}
                 else{
                 Toast.makeText(this,"რეგისტრაციისას დაფიქსირდა შეცდომა, სცადეთ მოგვიანებით ʕᵔᴥᵔʔ",Toast.LENGTH_SHORT).show()
                 }
             }}
         else{Toast.makeText(this,"გთხოვთ შეიყვანოთ თქვენი E-mail და პაროლი",Toast.LENGTH_SHORT).show()}
     }

}
}