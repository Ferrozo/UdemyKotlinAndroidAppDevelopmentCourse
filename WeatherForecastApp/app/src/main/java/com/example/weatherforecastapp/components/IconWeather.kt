package com.example.weatherforecastapp.components

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun IconWeather(image: String){
    val imageUrl = "https://openweathermap.org/img/wn/${image}.png";

    AsyncImage(
        model =  ImageRequest.Builder(LocalContext.current)
        .data(imageUrl)
        .crossfade(true)
        .build(), contentDescription = null,modifier = Modifier.size(50.dp)
    )
}