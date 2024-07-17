package com.example.weatherforecastapp.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weatherforecastapp.components.HomeTopAppBar
import com.example.weatherforecastapp.data.DataOrException
import com.example.weatherforecastapp.model.Weather
import com.example.weatherforecastapp.ui.theme.BlackColor
import com.example.weatherforecastapp.ui.theme.WhiteColor

@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel){
    DisplayWeather(navController=navController, homeViewModel= homeViewModel)
}

@Composable
fun DisplayWeather(homeViewModel: HomeViewModel, navController: NavController){
    val weatherData = produceState<DataOrException<Weather, Boolean, Exception>>(initialValue = DataOrException(loading = true)) {
        value = homeViewModel.getWeather("Luanda")
    }.value

    Scaffold(
        topBar = {
            HomeTopAppBar(navController)
        },
        containerColor = BlackColor
    ) {
        Column(
            modifier =
            Modifier.padding(it)
                .fillMaxSize()
        ) {
            if(weatherData.loading == true){
                Text(text = "Loading")
            }else if(weatherData.data != null){
                Text(
                    text = "Your City",
                    style = TextStyle(
                        color = WhiteColor,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }else {
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















