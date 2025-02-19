package com.example.weather.model.repositories

import com.example.weather.model.models.CurrentDayWeatherResponse
import com.example.weather.model.models.CurrentWeatherResponse
import com.example.weather.model.models.FiveDaysWeatherResponse
import com.example.weather.model.models.TwelveHourWeatherResponse
import com.example.weather.model.service.WeatherApiService
import com.example.weather.utils.safeApiCall
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val apiService: WeatherApiService) {

    suspend fun getCurrentWeather(locationKey: Int): Result<List<CurrentWeatherResponse>> =
        safeApiCall({ apiService.getCurrentWeather(locationKey) }, "Error fetching current weather")


    suspend fun getTwelveHourWeather(locationKey: Int): Result<List<TwelveHourWeatherResponse>> =
        safeApiCall({ apiService.getTwelveHourWeather(locationKey) }, "Error fetching twelve hour weather")


    suspend fun getFiveDaysWeather(locationKey: Int): Result<FiveDaysWeatherResponse> =
        safeApiCall({ apiService.getFiveDaysWeather(locationKey) }, "Error fetching five days weather")


    suspend fun getOneDayWeather(locationKey: Int): Result<CurrentDayWeatherResponse> =
        safeApiCall({ apiService.getOneDayWeather(locationKey) }, "Error fetching one day weather")

}