package com.veen.cars.activity.salesandservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.veen.cars.R
import com.veen.cars.databinding.ActivitySalesAndServiceBinding

class SalesAndServiceActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySalesAndServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sales_and_service)

        binding.enquiry.setOnClickListener {
            if (binding.enquiryLayout.visibility == View.GONE){
                binding.enquiryLayout.visibility = View.VISIBLE
            } else {
                binding.enquiryLayout.visibility = View.GONE
            }
        }

        binding.serviceMain.setOnClickListener {
            if (binding.serviceLayout.visibility == View.GONE){
                binding.serviceLayout.visibility = View.VISIBLE
            } else {
                binding.serviceLayout.visibility = View.GONE
            }
        }
    }
}