package com.bulingzhuang.mvvmtest.activity

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bulingzhuang.mvvmtest.R
import com.bulingzhuang.mvvmtest.databinding.ActivityWeatherBinding
import com.bulingzhuang.mvvmtest.viewModel.WeatherViewModel
import kotlinx.android.synthetic.main.activity_weather.*

class WeatherActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityWeatherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_weather)
        mBinding.weatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)
        mBinding.executePendingBindings()

        btn_refresh.setOnClickListener {
            mBinding.weatherViewModel?.refreshWeather(et_city.text.toString())
        }
    }
}
