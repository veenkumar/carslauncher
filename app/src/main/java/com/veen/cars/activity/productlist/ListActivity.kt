package com.veen.cars.activity.productlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.veen.cars.R
import com.veen.cars.databinding.ActivityListBinding
import com.veen.cars.fragment.productlist.WaterSprinklerFragment

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)

        this.supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, WaterSprinklerFragment())
            .commit()
    }
}