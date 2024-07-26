package com.example.weatherforecastapp.screens.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weatherforecastapp.R
import com.example.weatherforecastapp.components.SmallWeatherCard
import com.example.weatherforecastapp.components.WeatherDetailCard
import com.example.weatherforecastapp.model.Weather
import com.example.weatherforecastapp.ui.theme.BlackColor
import com.example.weatherforecastapp.util.fahrenheitToCelsius
import com.example.weatherforecastapp.util.formatTime


@Composable
fun DetailScreen(
    navController: NavController,
    weather: Weather
){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = BlackColor
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = rememberScrollState()),
        ) {
            WeatherDetailCard(
                popBack = { navController.popBackStack() },
                weather = weather
            )
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
            ) {
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    val temperatureCelsius = fahrenheitToCelsius(weather.main.temp).toInt()
                    SmallWeatherCard(
                        title = "FEE LIKE",
                        degrees = "${temperatureCelsius}º",
                        icon = painterResource(id = R.drawable.temperature),
                        description = "Humidity is making it feel warmer"
                    )
                    SmallWeatherCard(
                        title = "HUMIDITY",
                        degrees = "${weather.main.humidity}%",
                        icon = painterResource(id = R.drawable.humidity),
                        description = "Humidity is making it feel warmer"
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    SmallWeatherCard(
                        title = "VISIBILITY",
                        degrees = "${if(weather.visibility> 1000) "${weather.visibility/1000} km" else weather.visibility}",
                        icon =painterResource(id = R.drawable.wind2),
                        description = "Humidity is making it feel warmer"
                    )
                    SmallWeatherCard(
                        title = "SUNRISE",
                        degrees = formatTime(weather.sys.sunrise),
                        icon = painterResource(id = R.drawable.sunrise),
                        description = "Sunset: ${formatTime(weather.sys.sunset)}"
                    )
                }
            }
        }
    }
}