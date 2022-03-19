package com.veen.cars.ui.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.veen.cars.ui.fragment.MainScreenFragment

class DoppelgangerAdapter(activity: AppCompatActivity, val itemsCount: Int) :
    FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return itemsCount
    }

    override fun createFragment(position: Int): Fragment {
        println("Position $position")

        return when (position) {
            0 -> MainScreenFragment.getInstance(position)
            else -> MainScreenFragment.getInstance(position)
        }
    }
}