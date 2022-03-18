package com.veen.cars.activity.salesandservice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding
import androidx.databinding.DataBindingUtil
import com.veen.cars.R
import com.veen.cars.databinding.ActivitySalesAndServiceBinding

class SalesAndServiceActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySalesAndServiceBinding
    private var chooseType = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sales_and_service)

        binding.ssSales.setOnClickListener {
            chooseType = "1"
            getServiceType(chooseType)
        }

        binding.ssServices.setOnClickListener {
            chooseType = "2"
            getServiceType(chooseType)
        }
    }

    private fun getServiceType(type: String) {
        when(type){
            "1"->{
                binding.ssSales.setBackgroundResource(R.drawable.greybutton)
                binding.ssSales.setTextColor(getColor(R.color.white))

                binding.ssServices.setBackgroundResource(R.drawable.lightwhitebutton)
                binding.ssServices.setTextColor(getColor(R.color.black))
            }
            "2"->{
                binding.ssServices.setBackgroundResource(R.drawable.greybutton)
                binding.ssServices.setTextColor(getColor(R.color.white))

                binding.ssSales.setBackgroundResource(R.drawable.lightwhitebutton)
                binding.ssSales.setTextColor(getColor(R.color.black))
            }
        }
    }
}