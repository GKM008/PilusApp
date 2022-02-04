package com.example.pilusapp


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.pilusapp.adapters.ViewPagerFragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ProfileActivity : AppCompatActivity() {
    private lateinit var viewPager2 : ViewPager2
    private lateinit var tabLayout : TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        viewPager2 = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)

        viewPager2.adapter = ViewPagerFragmentAdapter(this)
        TabLayoutMediator(tabLayout,viewPager2){tab, position ->
            if(position == 0){
                tab.text = "პროფილი"
            }else{
                tab.text = "ძებნა"}

        }.attach()
    }
}