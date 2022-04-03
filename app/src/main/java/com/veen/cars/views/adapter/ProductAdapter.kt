package com.veen.cars.views.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.veen.cars.databinding.AdapterProductBinding
import com.veen.cars.model.product.all.Result
import com.veen.cars.views.activity.productlist.ListActivity

class ProductAdapter(private val context: Context, private val data: List<Result>) :
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
        binding.pheading.text = data[position].name
        Picasso.get().load(data[position].image).into(binding.pimage)

        binding.pdetails.setOnClickListener {
            context.startActivity(Intent(context, ListActivity::class.java))
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}