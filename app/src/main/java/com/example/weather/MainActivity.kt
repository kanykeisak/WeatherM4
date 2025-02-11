package com.example.weather

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.weather.databinding.ActivityMainBinding
import com.example.weather.model.models.WeatherResponse
import com.example.weather.presenter.WeatherContract
import com.example.weather.presenter.WeatherPresenter

class  MainActivity : AppCompatActivity(), WeatherContract.View {
    
    private lateinit var binding: ActivityMainBinding
    private val presenter by lazy {WeatherPresenter(this)}
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.loadData("Bishkek")
    }
    
    override fun showWeather(weatherResponse: WeatherResponse) {
        binding.apply {
            textview.text = weatherResponse.current?.tempC.toString()
        }
    }
    
    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    
    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}