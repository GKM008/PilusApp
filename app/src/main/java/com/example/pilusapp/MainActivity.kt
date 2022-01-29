package com.example.pilusapp


import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.pilusapp.models.UserInfo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {
    private lateinit var imageProfile: ImageView
    private lateinit var userName: TextView
    private lateinit var profileLink: EditText
    private lateinit var userNameInput: EditText
    private lateinit var buttonSave: Button
    private lateinit var buttonLogOut: Button
    private val db = FirebaseDatabase.getInstance().getReference("UserInfo")
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        onClickListeners()
        db.child(auth.currentUser?.uid!!).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val userInfo: UserInfo = snapshot.getValue(UserInfo::class.java) ?: return
                userName.text = userInfo.name
                Glide.with(this@MainActivity)
                    .load(userInfo.imageUrl).placeholder(R.drawable.defaultprofile)
                    .into(imageProfile)
            }


            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

    private fun init() {
        imageProfile = findViewById(R.id.imageProfile)
        userName = findViewById(R.id.userName)
        profileLink = findViewById(R.id.profileLink)
        userNameInput = findViewById(R.id.userNameInput)
        buttonSave = findViewById(R.id.buttonSave)
        buttonLogOut = findViewById(R.id.buttonLogOut)


    }
    private fun gotoProfile(){
        startActivity(Intent(this,ProfileActivity::class.java))
        finish()}
    private fun gotoLogin(){
        startActivity(Intent(this,LoginActivity::class.java))
    }
    private fun onClickListeners() {
        buttonSave.setOnClickListener {
            val name = userNameInput.text.toString()
            val link = profileLink.text.toString()


                val userInfo = UserInfo(name, link)
                db.child(auth.currentUser?.uid!!)
                    .setValue(userInfo)
                gotoProfile()
            buttonLogOut.setOnClickListener {
                gotoLogin()

        }

        }
    }
}
