package com.veen.cars.views.activity.salesandservice

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.veen.cars.R
import com.veen.cars.databinding.ActivitySalesAndServiceBinding
import com.veen.cars.model.salesandservice.SalesServiceReq
import com.veen.cars.utils.CommonFile
import com.veen.cars.utils.api.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class SalesAndServiceActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    private lateinit var binding: ActivitySalesAndServiceBinding
    private var chooseType = "1"

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

        binding.ssSendButton.setOnClickListener {
            when {
                TextUtils.isEmpty(binding.ssname.text.toString().trim()) -> {
                    Toast.makeText(applicationContext, "Please Enter Name", Toast.LENGTH_SHORT).show()
                }
                TextUtils.isEmpty(binding.sscompanyname.text.toString().trim()) -> {
                    Toast.makeText(applicationContext, "Please Enter Company Name", Toast.LENGTH_SHORT).show()
                }
                TextUtils.isEmpty(binding.ssaddress.text.toString().trim()) -> {
                    Toast.makeText(applicationContext, "Please Enter Address", Toast.LENGTH_SHORT).show()
                }
                TextUtils.isEmpty(binding.sscontact.text.toString().trim()) -> {
                    Toast.makeText(applicationContext, "Please Enter Contact Number", Toast.LENGTH_SHORT).show()
                }
                TextUtils.isEmpty(binding.ssemaildetails.text.toString().trim()) -> {
                    Toast.makeText(applicationContext, "Please Enter Email", Toast.LENGTH_SHORT).show()
                }
                TextUtils.isEmpty(binding.ssqueries.text.toString().trim()) -> {
                    Toast.makeText(applicationContext, "Please Enter Your Query", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    launch(Dispatchers.Main) {
                        try {
                            val response = RetrofitInstance.instance?.getSalesService(SalesServiceReq(
                                binding.ssaddress.text.toString(),
                                binding.sscompanyname.text.toString(),
                                binding.sscontact.text.toString(),
                                binding.ssemaildetails.text.toString(),
                                binding.ssname.text.toString(),
                                binding.ssqueries.text.toString(),
                                chooseType
                            ))
                            Toast.makeText(applicationContext, "${response?.message()}", Toast.LENGTH_SHORT).show()
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                }
            }
        }
    }

    private fun getServiceType(type: String) {
        when (type) {
            "1" -> {
                binding.ssSales.setBackgroundResource(R.drawable.greybutton)
                binding.ssSales.setTextColor(getColor(R.color.white))

                binding.ssServices.setBackgroundResource(R.drawable.lightwhitebutton)
                binding.ssServices.setTextColor(getColor(R.color.black))
            }
            "2" -> {
                binding.ssServices.setBackgroundResource(R.drawable.greybutton)
                binding.ssServices.setTextColor(getColor(R.color.white))

                binding.ssSales.setBackgroundResource(R.drawable.lightwhitebutton)
                binding.ssSales.setTextColor(getColor(R.color.black))
            }
        }
    }
}