package com.bulingzhuang.mvvmtest.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableField
import com.bulingzhuang.mvvmtest.entity.WeatherData
import com.bulingzhuang.mvvmtest.model.WeatherModel
import com.bulingzhuang.mvvmtest.net.ApiCallback
import com.bulingzhuang.mvvmtest.utils.showToast

/**
 * ================================================
 * 作    者：bulingzhuang
 * 邮    箱：bulingzhuang@foxmail.com
 * 创建日期：2017/11/16
 * 描    述：
 * ================================================
 */
class WeatherViewModel(application: Application) : AndroidViewModel(application) {
    private val mWeatherModel = WeatherModel()
    val mWeatherData = ObservableField<WeatherData.ResultsBean.NowBean>()
    val isLoading = ObservableField(false)

    private val weatherCallback = object : ApiCallback<WeatherData>() {
        override fun onSuccess(module: WeatherData) {
            mWeatherData.set(module.results[0].now)
        }

        override fun onFailure(msg: String?) {
            application.showToast(msg?.let { it } ?: "请求失败")
        }

        override fun onFinish() {
            isLoading.set(false)
        }
    }

    fun refreshWeather(city:String) {
        isLoading.set(true)
        mWeatherModel.refreshWeatherData(weatherCallback,city)
    }

    override fun onCleared() {
        super.onCleared()
        mWeatherModel.doOnDestory()
    }
}