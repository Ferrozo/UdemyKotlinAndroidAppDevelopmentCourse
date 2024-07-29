package com.example.weatherforecastapp.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherforecastapp.data.DataOrException
import com.example.weatherforecastapp.model.Weather
import com.example.weatherforecastapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (private val repository: WeatherRepository): ViewModel() {
    val data: MutableState<DataOrException<Weather, Boolean, Exception>>
    = mutableStateOf(DataOrException(null, true, Exception("")))

    private val cityWeatherData: MutableState<Map<String, DataOrException<Weather, Boolean, Exception>>> =
        mutableStateOf(mapOf())
    suspend fun getWeather(city: String): DataOrException<Weather, Boolean, Exception>{
        return repository.getWeather(cityQuery = city)
    }

    suspend fun getWeatherByCoord(lat: Double, lon: Double): DataOrException<Weather, Boolean, Exception>{
        return repository.getWeatherByCoord(lat, lon)
    }

    fun searchWeather(city: String, onResult:  (DataOrException<Weather, Boolean, Exception>) -> Unit) {
        viewModelScope.launch {
            val result = getWeather(city)
            onResult(result)
        }
    }

    suspend fun fetchWeatherForCities(cities: List<String>): List<DataOrException<Weather, Boolean, Exception>> {
        return cities.map { city ->
            getWeather(city)
        }
    }
}