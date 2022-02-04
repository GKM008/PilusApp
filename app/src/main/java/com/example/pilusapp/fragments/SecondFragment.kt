package com.example.pilusapp.fragments
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.pilusapp.R
import com.example.pilusapp.UserlistActivity

class SecondFragment : Fragment(R.layout.fragment_second){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonSearch = view.findViewById<Button>(R.id.buttonSearch)
        buttonSearch.setOnClickListener {
            requireActivity().run{
                startActivity(Intent(this, UserlistActivity::class.java))
                finish()
            }
        }
    }
}