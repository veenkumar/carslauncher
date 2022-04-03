package com.veen.cars.views.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.veen.cars.R
import com.veen.cars.databinding.ActivityMainBinding
import com.veen.cars.views.activity.helpline.HelplineActivity
import com.veen.cars.views.activity.manual.OperatingManualActivity
import com.veen.cars.views.activity.productlist.ProductListActivity
import com.veen.cars.views.activity.salesandservice.SalesAndServiceActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.homebutton.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        binding.leftone.setOnClickListener {
            startActivity(Intent(this, SalesAndServiceActivity::class.java))
        }

        binding.lefttwo.setOnClickListener {
            startActivity(Intent(this, HelplineActivity::class.java))
        }

        binding.rightone.setOnClickListener {
            startActivity(Intent(this, OperatingManualActivity::class.java))
        }

        binding.righttwo.setOnClickListener {
            startActivity(Intent(this, ProductListActivity::class.java))
        }
    }
}