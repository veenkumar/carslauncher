package com.veen.cars.views.activity.productlist

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import com.veen.cars.R
import com.veen.cars.databinding.ActivityListBinding
import com.veen.cars.model.product.details.ProductDetailsReq
import com.veen.cars.model.product.details.ProductDetailsRes
import com.veen.cars.model.product.details.Result
import com.veen.cars.utils.CommonFile
import com.veen.cars.utils.CommonFile.TAG
import com.veen.cars.utils.api.RetrofitInstance
import com.veen.cars.views.adapter.ProductListAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@RequiresApi(Build.VERSION_CODES.N)
class ListActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    private lateinit var binding: ActivityListBinding
    private lateinit var adapter: ProductListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)

        launch(Dispatchers.Main) {
            try {
//                val response = RetrofitInstance.instance?.getProductDetails(ProductDetailsReq("1"))
//                bindMyData(response?.body()?.result!!)
                /*if (response?.body()?.result != null){
                } else {
                    Toast.makeText(applicationContext, CommonFile.ErrorMessage, Toast.LENGTH_SHORT).show()
                }*/


            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        RetrofitInstance.instance?.getProductDetails(ProductDetailsReq("1"))!!.enqueue(object :
            Callback<ProductDetailsRes>{
            override fun onResponse(
                call: Call<ProductDetailsRes>,
                response: Response<ProductDetailsRes>
            ) {
                bindMyData(response.body()?.result!!)
            }

            override fun onFailure(call: Call<ProductDetailsRes>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })

        /*binding.listRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter = ProductListAdapter(this)
        binding.listRecyclerView.adapter = adapter*/
    }


    private fun bindMyData(data: Result) {
        try {
            binding.productTitle.text = data.name
            Picasso.get().load(data.image).into(binding.imageView2)
            binding.productDetailsss.text = Html.fromHtml(data.detail, Html.FROM_HTML_MODE_COMPACT);
            binding.tabledata.text = Html.fromHtml(data.technical_data, Html.FROM_HTML_MODE_COMPACT);
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}