package com.veen.cars.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.veen.cars.databinding.AdapterProductBinding

class ProductAdapter(private val context: Context) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    private lateinit var binding: AdapterProductBinding

    inner class ViewHolder(itemView: AdapterProductBinding) : RecyclerView.ViewHolder(itemView.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = AdapterProductBinding.inflate(
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