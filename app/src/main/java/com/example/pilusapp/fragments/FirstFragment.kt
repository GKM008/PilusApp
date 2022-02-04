package com.example.pilusapp.fragments
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.pilusapp.*

class FirstFragment : Fragment(R.layout.fragment_first){


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonChange = view.findViewById<Button>(R.id.buttonChange)
        val buttonLogOut = view.findViewById<Button>(R.id.buttonLogOut)

        buttonChange.setOnClickListener {
            requireActivity().run{
                startActivity(Intent(this, MainActivity::class.java))

            }
        }

        buttonLogOut.setOnClickListener {
            requireActivity().run{
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
            }
        }

    }
}