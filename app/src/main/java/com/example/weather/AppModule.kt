package com.example.weather

import android.app.Application
import com.example.weather.model.core.RetrofitClient
import com.example.weather.model.repositories.WeatherRepository
import com.example.weather.model.service.WeatherApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideRetrofitClient(context: Application): RetrofitClient {
        return RetrofitClient.getInstance(context)
    }

    @Provides
    fun provideWeatherApiService(retrofitClient: RetrofitClient): WeatherApiService {
        return retrofitClient.retrofitService
    }

    @Provides
    fun provideWeatherRepository(weatherApiService: WeatherApiService): WeatherRepository {
        return WeatherRepository(weatherApiService)
    }
}