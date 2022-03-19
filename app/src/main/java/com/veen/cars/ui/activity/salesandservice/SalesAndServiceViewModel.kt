package com.veen.cars.ui.activity.salesandservice

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.veen.cars.utils.api.RetrofitInstance
import kotlinx.coroutines.launch

class SalesAndServiceViewModel: ViewModel() {
    private val TAG = "SalesAndServiceViewMode"

    fun getResponse(){
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.instance?.getSalesService()
                if (response!!.isSuccessful && response.body()?.data != null){
                    response.body()?.data
                    Log.d(TAG, "getResponse: ${response.body()?.data}")
                } else {
                    Log.d(TAG, "getResponse: ${response.body()?.data}")
                }
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}