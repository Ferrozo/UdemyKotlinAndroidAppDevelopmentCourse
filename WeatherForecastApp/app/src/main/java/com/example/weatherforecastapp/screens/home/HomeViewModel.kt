package com.example.weatherforecastapp.screens.home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherforecastapp.data.DataOrException
import com.example.weatherforecastapp.model.Weather
import com.example.weatherforecastapp.model.WeatherObject
import com.example.weatherforecastapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (private val repository: WeatherRepository): ViewModel() {
    val data: MutableState<DataOrException<Weather, Boolean, Exception>>
    = mutableStateOf(DataOrException(null, true, Exception("")))

    val currentLocationData: MutableState<DataOrException<Weather, Boolean, Exception>>
            = mutableStateOf(DataOrException(null, true, Exception("")))
    suspend fun getWeather(city: String): DataOrException<Weather, Boolean, Exception>{
        return repository.getWeather(cityQuery = city)
    }

    suspend fun getWeatherByCoord(lat: Double, lon: Double): DataOrException<Weather, Boolean, Exception>{
        return repository.getWeatherByCoord(lat, lon)
    }
}