package com.veen.cars.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.veen.cars.R
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
            Toast.makeText(applicationContext, "No File Available", Toast.LENGTH_SHORT).show()
        }

        binding.lefttwo.setOnClickListener {
            Toast.makeText(applicationContext, "No File Available", Toast.LENGTH_SHORT).show()
        }

        binding.rightone.setOnClickListener {
            Toast.makeText(applicationContext, "No File Available", Toast.LENGTH_SHORT).show()
        }

        binding.righttwo.setOnClickListener {
            Toast.makeText(applicationContext, "No File Available", Toast.LENGTH_SHORT).show()
        }
    }
}