package com.veen.cars.activity

import android.appwidget.AppWidgetManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.veen.cars.R
import com.veen.cars.adapter.DoppelgangerAdapter
import com.veen.cars.databinding.ActivityHomeBinding
import com.veen.cars.utils.ViewPager2PageTransformation

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        val pagerAdapter = DoppelgangerAdapter(this, 1)
        binding.viewPager.adapter = pagerAdapter
        binding.viewPager.setPageTransformer(ViewPager2PageTransformation())


        // Get a list of all installed widgets
        val mAppWidgetManager =
            AppWidgetManager.getInstance(applicationContext)
        val infoList =
            mAppWidgetManager.installedProviders
    }
}