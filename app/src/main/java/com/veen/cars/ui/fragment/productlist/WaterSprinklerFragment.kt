package com.veen.cars.ui.fragment.productlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.veen.cars.R
import com.veen.cars.ui.adapter.ImageSliderAdapter
import com.veen.cars.ui.adapter.ProductListAdapter
import com.veen.cars.databinding.FragmentWaterSprinklerBinding

class WaterSprinklerFragment : Fragment() {
    private lateinit var binding: FragmentWaterSprinklerBinding
    private lateinit var adapter: ProductListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_water_sprinkler, container, false)
        imageSliderImplementation()

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter = ProductListAdapter(requireContext())
        binding.recyclerView.adapter = adapter

        return binding.root
    }

    private fun imageSliderImplementation() {
        val adapter = ImageSliderAdapter(requireContext())
        binding.viewPager.adapter = adapter
    }


}