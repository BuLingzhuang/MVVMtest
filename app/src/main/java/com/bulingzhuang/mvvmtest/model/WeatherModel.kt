package com.bulingzhuang.mvvmtest.model

import com.bulingzhuang.mvvmtest.entity.WeatherData
import com.bulingzhuang.mvvmtest.net.ApiClient
import com.bulingzhuang.mvvmtest.net.BaseObserver

/**
 * ================================================
 * 作    者：bulingzhuang
 * 邮    箱：bulingzhuang@foxmail.com
 * 创建日期：2017/11/16
 * 描    述：
 * ================================================
 */
class WeatherModel : BaseModel() {

    fun refreshWeatherData(observer: BaseObserver<WeatherData>, city: String = "上海") {
        if (city.isEmpty()) {
            addSubscription(ApiClient.retrofit().loadWeather(), observer)
        } else {
            addSubscription(ApiClient.retrofit().loadWeather(city), observer)
        }
    }
}