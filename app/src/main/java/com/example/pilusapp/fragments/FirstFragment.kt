package com.example.pilusapp.fragments
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.pilusapp.MainActivity
import com.example.pilusapp.R
import com.example.pilusapp.UserlistActivity

class FirstFragment : Fragment(R.layout.fragment_first){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonChange = view.findViewById<Button>(R.id.buttonChange)
        buttonChange.setOnClickListener {
            requireActivity().run{
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }
}