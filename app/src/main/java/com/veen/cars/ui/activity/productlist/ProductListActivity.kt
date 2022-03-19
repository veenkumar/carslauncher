package com.veen.cars.ui.activity.productlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.veen.cars.R
import com.veen.cars.databinding.ActivityProductListBinding
import com.veen.cars.ui.adapter.ProductAdapter
import com.veen.cars.ui.adapter.ProductListAdapter
import com.veen.cars.ui.fragment.productlist.WaterSprinklerFragment

class ProductListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductListBinding
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_list)

        binding.productRecyclerView.layoutManager = GridLayoutManager(this, 2)
        adapter = ProductAdapter(this)
        binding.productRecyclerView.adapter = adapter
    }
}