package com.example.weatherforecastapp.screens.home

import android.Manifest
import android.content.pm.PackageManager
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.weatherforecastapp.components.DarkWeatherCard
import com.example.weatherforecastapp.components.HomeTopAppBar
import com.example.weatherforecastapp.components.WeatherCard
import com.example.weatherforecastapp.data.DataOrException
import com.example.weatherforecastapp.model.Weather
import com.example.weatherforecastapp.ui.theme.BlackColor
import com.example.weatherforecastapp.ui.theme.WhiteColor
import com.example.weatherforecastapp.util.LocationResult
import com.example.weatherforecastapp.util.getCurrentLocation


@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel){
    DisplayWeather(navController=navController, homeViewModel= homeViewModel)
}

@Composable
fun DisplayWeather(homeViewModel: HomeViewModel, navController: NavController) {
    val context = LocalContext.current
    val location = remember { mutableStateOf<LocationResult?>(null) }
    val isLocationFetched = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        try {
            val permissionGranted = ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED

            if (permissionGranted) {
                location.value = getCurrentLocation(context)
                isLocationFetched.value = true
                location.value?.let {
                    //
                }
            } else {
                //
            }
        } catch (e: Exception) {
                //
        }
    }

    val weatherData = produceState<DataOrException<Weather, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)
    ) {
        value = homeViewModel.getWeather("Lubango")
    }

    Scaffold(
        topBar = {
            HomeTopAppBar(navController)
        },
        containerColor = BlackColor
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            if (weatherData.value.loading == true) {
                Text(text = "Loading")
            } else if (weatherData.value.data != null) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .verticalScroll(
                            state = rememberScrollState()
                        )
                ) {
                    Text(
                        text = "Your City",
                        style = TextStyle(
                            color = WhiteColor,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    CurrentCityWeather(location = location.value, homeViewModel = homeViewModel)
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Favorite List",
                        style = TextStyle(
                            color = WhiteColor,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    DarkWeatherCard(weather = weatherData.value.data!!)
                    Spacer(modifier = Modifier.height(10.dp))
                    DarkWeatherCard(weather = weatherData.value.data!!)
                    Spacer(modifier = Modifier.height(10.dp))
                    DarkWeatherCard(weather = weatherData.value.data!!)
                    Spacer(modifier = Modifier.height(10.dp))
                    DarkWeatherCard(weather = weatherData.value.data!!)
                }
            } else {
                Text(
                    text = "Error",
                    style = TextStyle(
                        color = WhiteColor,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}
@Composable
fun CurrentCityWeather(location: LocationResult?, homeViewModel: HomeViewModel) {
    val currentCityWeatherData = produceState<DataOrException<Weather, Boolean, Exception>>(initialValue = DataOrException(loading = true)) {
        if (location != null) {
            try {
                value = homeViewModel.getWeatherByCoord(lat = location.latitude, lon = location.longitude)
            } catch (e: Exception) {
                Log.e("WeatherError", "Exception while fetching weather: ${e.message}")
                value = DataOrException(e = e)
            }
        }
    }.value

    if (location != null) {
        Column {
            if (currentCityWeatherData.loading == true) {
                Text(text = "Loading current city weather...", style = TextStyle(color = Color.White))
            } else if (currentCityWeatherData.data != null) {
                WeatherCard(weather = currentCityWeatherData.data!!)
            } else if (currentCityWeatherData.e != null) {
                Text(text = "Error loading weather data: ${currentCityWeatherData.e?.message}", style = TextStyle(color = Color.Red))
            }
        }
    } else {
        Text(text = "Fetching location...", style = TextStyle(color = Color.White))
    }
}