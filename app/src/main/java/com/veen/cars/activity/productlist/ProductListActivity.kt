package com.veen.cars.activity.productlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.veen.cars.R
import com.veen.cars.databinding.ActivityProductListBinding
import com.veen.cars.fragment.productlist.WaterSprinklerFragment

class ProductListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_list)

        binding.tvwater.setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java))
        }
        binding.tvGarbage.setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java))
        }
        binding.tvGarbageCompact.setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java))
        }
        binding.tvHook.setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java))
        }
        binding.tvStaticCompact.setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java))
        }
        binding.tvDumper.setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java))
        }
        binding.tvSewer.setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java))
        }
        binding.tvDesilting.setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java))
        }
        binding.tvRecycler.setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java))
        }
        binding.tvRoad.setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java))
        }
        binding.tvNala.setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java))
        }
        binding.tvHydraulic.setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java))
        }
    }
}