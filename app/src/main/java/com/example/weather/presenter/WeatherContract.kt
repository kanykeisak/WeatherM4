package com.example.weather.presenter

import android.os.Message
import com.example.weather.model.models.WeatherResponse

interface WeatherContract {
    interface View{
        fun showWeather(weatherResponse: WeatherResponse)
        fun showError(message: String)
    }
    interface Presenter {
        fun loadData(location: String)
        fun onDestroy()
    }
}