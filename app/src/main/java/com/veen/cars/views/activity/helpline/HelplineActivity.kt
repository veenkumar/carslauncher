package com.veen.cars.views.activity.helpline

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.veen.cars.R
import com.veen.cars.databinding.ActivityHelplineBinding
import com.veen.cars.utils.CommonFile
import com.veen.cars.utils.CommonFile.ErrorMessage
import com.veen.cars.utils.api.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class HelplineActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    private lateinit var binding: ActivityHelplineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_helpline)

        launch(Dispatchers.Main) {
            try {
                val response = RetrofitInstance.instance?.getHelplineContact()
                if (response?.body()?.result!!.isNotEmpty()){
                    binding.number1.text = response.body()!!.result[0].phone1
                    binding.number2.text = response.body()!!.result[0].phone2
                    binding.email1.text = response.body()!!.result[0].eamil1
                    binding.email2.text = response.body()!!.result[0].email2
                } else {
                    Toast.makeText(applicationContext, ErrorMessage, Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }
}