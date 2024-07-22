package com.example.weatherforecastapp.screens.home

import android.Manifest
import android.content.pm.PackageManager
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.scrollable
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
            // Ensure permissions are granted
            val permissionGranted = ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED

            if (permissionGranted) {
                location.value = getCurrentLocation(context)
                isLocationFetched.value = true
            } else {
                // Handle the case where location permission is not granted
                // You might want to request permission here if necessary
            }
        } catch (e: Exception) {
            // Log or handle exception
            e.printStackTrace()
        }
    }

    val weatherData = produceState<DataOrException<Weather, Boolean, Exception>>(initialValue = DataOrException(loading = true)) {
        value = homeViewModel.getWeather("Lubango")
    }.value

    Scaffold(
        topBar = {
            HomeTopAppBar(navController)
        },
        containerColor = BlackColor
    ) {
        Column(
            modifier =
            Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            if(weatherData.loading == true){
                Text(text = "Loading")
            } else if(weatherData.data != null){
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
                    LocationDisplay(location = location.value)
                    Spacer(modifier = Modifier.height(20.dp))
                    WeatherCard(weather = weatherData.data!! )
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
                    DarkWeatherCard(weather = weatherData.data!! )
                    Spacer(modifier = Modifier.height(10.dp))
                    DarkWeatherCard(weather = weatherData.data!! )
                    Spacer(modifier = Modifier.height(10.dp))
                    DarkWeatherCard(weather = weatherData.data!! )
                    Spacer(modifier = Modifier.height(10.dp))
                    DarkWeatherCard(weather = weatherData.data!! )
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
fun LocationDisplay(location: LocationResult?) {
    if (location != null) {
        Text(text = "Latitude: ${location.latitude}, Longitude: ${location.longitude}", style = TextStyle(color = Color.White))
    } else {
        Text(text = "Fetching location...", style = TextStyle(color = Color.White) )
    }
}