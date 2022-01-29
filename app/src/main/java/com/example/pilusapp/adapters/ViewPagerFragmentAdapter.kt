package com.example.pilusapp.adapters

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pilusapp.fragments.FirstFragment
import com.example.pilusapp.fragments.SecondFragment

class ViewPagerFragmentAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
    if(position == 0){
        return FirstFragment()
    }else{
        return SecondFragment()
    }
    }
}