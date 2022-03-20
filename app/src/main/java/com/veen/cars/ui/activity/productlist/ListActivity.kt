package com.veen.cars.ui.activity.productlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.veen.cars.R
import com.veen.cars.databinding.ActivityListBinding
import com.veen.cars.ui.adapter.ProductAdapter
import com.veen.cars.ui.adapter.ProductListAdapter

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    private lateinit var adapter: ProductListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)

        binding.listRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter = ProductListAdapter(this)
        binding.listRecyclerView.adapter = adapter
    }
}