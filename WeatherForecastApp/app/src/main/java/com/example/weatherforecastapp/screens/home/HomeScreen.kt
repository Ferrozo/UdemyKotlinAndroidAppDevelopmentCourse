package com.example.weatherforecastapp.screens.home

import android.Manifest
import android.content.pm.PackageManager
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
import com.example.weatherforecastapp.navigation.AppScreens
import com.example.weatherforecastapp.ui.theme.BlackColor
import com.example.weatherforecastapp.ui.theme.WhiteColor
import com.example.weatherforecastapp.util.LocationResult
import com.example.weatherforecastapp.util.getCurrentLocation
import com.google.gson.Gson


@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel){
    DisplayWeather(navController=navController, homeViewModel= homeViewModel)
}

@Composable
fun DisplayWeather(homeViewModel: HomeViewModel, navController: NavController) {
    val location = remember { mutableStateOf<LocationResult?>(null) }

    val weatherData = produceState<DataOrException<Weather, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)
    ) {
        value = homeViewModel.getWeather("Paris")
    }
    val cityWeatherData = remember { mutableStateOf(listOf<DataOrException<Weather, Boolean, Exception>>()) }
    val cities = listOf("Paris", "New York","Tokyo", "Sydney")

    val context = LocalContext.current
    val isLocationFetched = remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        val fetchedWeatherData = homeViewModel.fetchWeatherForCities(cities)
        cityWeatherData.value = fetchedWeatherData
        try {
            val permissionGranted = ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED

            if (permissionGranted) {
                location.value = getCurrentLocation(context)
                isLocationFetched.value = true
                location.value?.let {
                }
            }
        } catch (e: Exception) {
            //
        }
    }

    Scaffold(
        topBar = {
            HomeTopAppBar(navController= navController, homeViewModel = homeViewModel)
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
                    CurrentCityWeather(
                        navController  = navController,
                        location = location.value,
                        homeViewModel = homeViewModel,

                        )
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
                    cityWeatherData.value.forEach { weatherData ->
                        if (weatherData.data != null) {
                            DarkWeatherCard(
                                weather = weatherData.data!!,
                                onClicked = {
                                    val weatherJson = Gson().toJson(weatherData.data)
                                    navController.navigate("${AppScreens.DetailScreen.name}/$weatherJson")
                                }
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                        } else if (weatherData.e != null) {
                            Text(
                                text = "Error loading weather data: ${weatherData.e?.message}",
                                style = TextStyle(color = Color.Red)
                            )
                        }
                    }
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
fun CurrentCityWeather(
    navController: NavController,
    location: LocationResult?,
    homeViewModel: HomeViewModel
) {
    val weatherState = remember { mutableStateOf<DataOrException<Weather, Boolean, Exception>>(DataOrException(loading = true)) }
    val isWeatherFetched = remember { mutableStateOf(false) }

    LaunchedEffect(location) {
        if (location != null && !isWeatherFetched.value) {
            try {
                weatherState.value = homeViewModel.getWeatherByCoord(lat = location.latitude, lon = location.longitude)
                isWeatherFetched.value = true
            } catch (e: Exception) {
                weatherState.value = DataOrException(e = e)
            }
        }
    }

    if (location != null) {
        Column {
            if (weatherState.value.loading == true) {
                Text(text = "Loading current city weather...", style = TextStyle(color = Color.White))
            } else if (weatherState.value.data != null) {
                WeatherCard(
                    weather = weatherState.value.data!!,
                    onClicked = {
                        val weatherJson = Gson().toJson(weatherState.value.data)
                        navController.navigate("${AppScreens.DetailScreen.name}/$weatherJson")
                    }
                )
            } else if (weatherState.value.e != null) {
                Text(text = "Error loading weather data: ${weatherState.value.e?.message}", style = TextStyle(color = Color.Red))
            }
        }
    } else {
        Text(text = "Fetching location...", style = TextStyle(color = Color.White))
    }
}