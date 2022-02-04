package com.example.pilusapp


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class PasswordChangeActivity : AppCompatActivity() {
    private lateinit var buttonPasswordChange : Button
    private lateinit var editTextPassword : EditText
    private lateinit var editTextPasswordSc : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_change)
    init()
    registerListeners()
    }
    private fun init(){
        buttonPasswordChange = findViewById(R.id.buttonPasswordChange)
        editTextPassword = findViewById(R.id.editTextPassword)
        editTextPasswordSc = findViewById(R.id.editTextPasswordSc)

    }
    private fun gotoProfile(){
        startActivity(Intent(this,ProfileActivity::class.java))
    }
    private fun registerListeners(){
        buttonPasswordChange.setOnClickListener {
            if(editTextPassword.text.toString() == editTextPasswordSc.text.toString()) {
                val newPassword = editTextPassword.text.toString()
                if(newPassword.isEmpty()){
                    Toast.makeText(this,"შეიყვანეთ ახალი პაროლი",Toast.LENGTH_SHORT).show()
                }
                else{
                    FirebaseAuth.getInstance().currentUser
                        ?.updatePassword(newPassword)
                        ?.addOnCompleteListener { task ->
                            if(task.isSuccessful){
                                Toast.makeText(this,"თქვენი პაროლი წარმატებით შეიცვალა",Toast.LENGTH_SHORT).show()
                                gotoProfile()
                            }
                            else{
                                Toast.makeText(this,"პაროლის შეცვლისას დაფიქსირდა შეცდომა",Toast.LENGTH_SHORT).show()
                            }
                        }
                }
            }
            else{
                Toast.makeText(this,"შეყვანილი პაროლები არ ემთხვევა",Toast.LENGTH_LONG).show()
            }
        }
    }

}