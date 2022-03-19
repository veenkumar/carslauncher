package com.veen.cars.ui.activity.helpline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.veen.cars.R
import com.veen.cars.databinding.ActivityHelplineBinding

class HelplineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHelplineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_helpline)
    }
}