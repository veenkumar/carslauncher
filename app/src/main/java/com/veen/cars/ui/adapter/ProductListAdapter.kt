package com.veen.cars.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.veen.cars.databinding.AdapterProductlistBinding

class ProductListAdapter(private val context: Context) :
    RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {
    private lateinit var binding: AdapterProductlistBinding

    inner class ViewHolder(itemView: AdapterProductlistBinding) : RecyclerView.ViewHolder(itemView.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = AdapterProductlistBinding.inflate(
            LayoutInflater.from(
                context
            ), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //todo rest of work here
    }

    override fun getItemCount(): Int {
        return 8
    }
}