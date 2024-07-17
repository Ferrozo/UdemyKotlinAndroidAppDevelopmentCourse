package com.example.weatherforecastapp.repository

import com.example.weatherforecastapp.data.DataOrException
import com.example.weatherforecastapp.model.Weather
import com.example.weatherforecastapp.model.WeatherObject
import com.example.weatherforecastapp.network.WeatherAPI
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherAPI) {
    suspend fun getWeather(cityQuery: String): DataOrException<Weather, Boolean, Exception>  {
        val response = try {
            api.getWeather(query = cityQuery)
        } catch (e: Exception){
            return DataOrException(e = e)
        }
        return DataOrException(data = response)
    }
}