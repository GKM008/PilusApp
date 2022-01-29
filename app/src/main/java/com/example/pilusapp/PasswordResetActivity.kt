package com.example.pilusapp


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class PasswordResetActivity : AppCompatActivity() {
    private lateinit var editTextEmail : EditText
    private lateinit var buttonSendEmail : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_reset)
    init()
    registerListeners()
    }
    private fun init(){
    editTextEmail = findViewById(R.id.editTextEmail)
    buttonSendEmail = findViewById(R.id.buttonSendEmail)

    }
    private fun registerListeners(){
        buttonSendEmail.setOnClickListener {
            val email = editTextEmail.text.toString()
            if(email.isEmpty()){
                Toast.makeText(this,"შეიყვანეთ თქვენი E-mail პაროლის აღსადგენად (ᵔᴥᵔ)",Toast.LENGTH_SHORT).show()
                return@setOnClickListener }
            else{
            FirebaseAuth.getInstance().sendPasswordResetEmail(email).
                    addOnCompleteListener { task ->
                        if(task.isSuccessful){
                            Toast.makeText(this,"პაროლის აღსადგენი ლინკი გამოგზავნილია თქვენს მაილზე (｡◕‿‿◕｡)",Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this,LoginActivity::class.java) )
                        }
                        else{
                            Toast.makeText(this,"დაფიქსირდა შეცდომა, დამატებითი ინფორმაციისთვის მიმართეთ პრეს-ცენტრს (✿´‿`)",Toast.LENGTH_LONG).show()
                        }

                    }

            }
        }
    }
}