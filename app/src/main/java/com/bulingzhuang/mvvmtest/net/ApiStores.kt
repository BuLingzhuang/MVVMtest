package com.bulingzhuang.mvvmtest.net

import com.bulingzhuang.mvvmtest.entity.WeatherData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * ================================================
 * 作    者：bulingzhuang
 * 版    本：1.0
 * 邮    箱：bulingzhuang@foxmail.com
 * 创建日期：2017/11/8
 * 描    述：Api合集
 * ================================================
 */
interface ApiStores {
    companion object {
        val API_NEW_WEATHER_SERVER_URL = "https://api.seniverse.com/"
    }

    @GET("v3/weather/now.json")
    fun loadWeather(@Query("location") location: String = "上海", @Query("key") key: String = "0dgqeyrbpaxdhejn",
                    @Query("language") language: String = "zh-Hans", @Query("unit") unit: String = "c"): Observable<WeatherData>
}