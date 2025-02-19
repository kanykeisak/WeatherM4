package com.example.weather.view.adapters

import android.annotation.SuppressLint
import com.example.weather.model.models.FiveDaysWeatherResponse
import com.example.weather.model.models.TwelveHourWeatherResponse

class GenericDiffUtil<T: Any> : androidx.recyclerview.widget.DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return when {
            oldItem is TwelveHourWeatherResponse && newItem is TwelveHourWeatherResponse -> oldItem.epochDateTime == newItem.epochDateTime
            oldItem is FiveDaysWeatherResponse.DailyForecast && newItem is FiveDaysWeatherResponse.DailyForecast -> oldItem.epochDate == newItem.epochDate
            else -> false
        }
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return when {
            oldItem is TwelveHourWeatherResponse && newItem is TwelveHourWeatherResponse -> oldItem == newItem
            oldItem is FiveDaysWeatherResponse.DailyForecast && newItem is FiveDaysWeatherResponse.DailyForecast -> oldItem == newItem
            else -> false
        }
    }
}