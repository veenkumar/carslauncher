package com.veen.cars.views.activity.productlist

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.veen.cars.R
import com.veen.cars.databinding.ActivityProductListBinding
import com.veen.cars.model.product.all.Result
import com.veen.cars.utils.CommonFile.ErrorMessage
import com.veen.cars.utils.api.RetrofitInstance
import com.veen.cars.views.adapter.ProductAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class ProductListActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    private lateinit var binding: ActivityProductListBinding
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_list)

        launch(Dispatchers.Main){
            try {
                val response = RetrofitInstance.instance?.getAllProductList()
                if (response?.body()?.result!!.isNotEmpty()){
                    bindMyData(response.body()?.result!!)
                } else {
                    Toast.makeText(applicationContext, ErrorMessage, Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    private fun bindMyData(result: List<Result>) {
        try {
            binding.productRecyclerView.layoutManager = GridLayoutManager(this, 2)
            adapter = ProductAdapter(this, result)
            binding.productRecyclerView.adapter = adapter
        } catch (e: Exception){
            e.printStackTrace()
        }
    }
}