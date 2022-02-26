package com.veen.cars.activity.salesandservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.veen.cars.R
import com.veen.cars.databinding.ActivitySalesAndServiceBinding

class SalesAndServiceActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySalesAndServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sales_and_service)
    }
}