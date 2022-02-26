package com.veen.cars.activity.manual

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.veen.cars.R
import com.veen.cars.adapter.ImageSliderAdapter
import com.veen.cars.databinding.ActivityOperatingManualBinding

class OperatingManualActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOperatingManualBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_operating_manual)
        imageSliderImplementation()
    }

    private fun imageSliderImplementation() {
        val adapter = ImageSliderAdapter(this)
        binding.viewPager.adapter = adapter
    }
}