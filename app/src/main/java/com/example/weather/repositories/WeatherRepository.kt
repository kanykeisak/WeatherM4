package com.example.weather.repositories

import com.example.weather.model.core.RetrofitClient
import com.example.weather.model.models.WeatherResponse


class WeatherRepository {
    private val apiKey = "2d5237966f194da68be135953251002"
//    2d5237966f194da68be135953251002
    
    suspend fun getCurrentWeather(location: String): WeatherResponse =
        RetrofitClient.retrofitService.getCurrentWeather(apiKey, location)
}