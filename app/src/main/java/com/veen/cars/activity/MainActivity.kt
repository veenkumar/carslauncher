package com.veen.cars.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.veen.cars.R
import com.veen.cars.activity.helpline.HelplineActivity
import com.veen.cars.activity.manual.OperatingManualActivity
import com.veen.cars.activity.productlist.ProductListActivity
import com.veen.cars.activity.salesandservice.SalesAndServiceActivity
import com.veen.cars.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

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