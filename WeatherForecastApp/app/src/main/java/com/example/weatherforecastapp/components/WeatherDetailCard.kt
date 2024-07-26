package com.example.weatherforecastapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.weatherforecastapp.model.Weather
import com.example.weatherforecastapp.ui.theme.BlackColor
import com.example.weatherforecastapp.ui.theme.BlueColor
import com.example.weatherforecastapp.ui.theme.PinkColor
import com.example.weatherforecastapp.util.fahrenheitToCelsius


@Composable
fun WeatherDetailCard(
    popBack: ()-> Unit,
    weather: Weather
){
    val temperatureCelsius = fahrenheitToCelsius(weather.main.temp)
    val imageUrl = "https://openweathermap.org/img/wn/${weather.weather.first().icon}.png"
    Box(modifier = Modifier.fillMaxSize()){
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            shape = CircleShape.copy(
                topEnd = CornerSize(0.dp),
                topStart = CornerSize(0.dp),
                bottomStart = CornerSize(40.dp),
                bottomEnd = CornerSize(40.dp)
            ),
            color = when (weather.weather.first().main) {
                "Clear" -> Color.Yellow
                "Clouds" -> BlueColor
                "Rain" -> PinkColor
                else -> Color.White
            }
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(40.dp)
            ) {
                Text(
                    text = "${weather.name}, ${weather.sys.country}",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = weather.weather.first().main,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "%.0fº".format(temperatureCelsius),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 65.sp,
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model =  ImageRequest.Builder(LocalContext.current)
                            .data(imageUrl)
                            .crossfade(true)
                            .build(), contentDescription = null,modifier = Modifier.size(40.dp)
                    )
                    Text(
                        text = weather.weather.first().description,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    )
                }
            }
        }
        IconButton(
            modifier = Modifier.padding(vertical = 20.dp),
            onClick = popBack
        ) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = null,
                tint = BlackColor
            )
        }
    }
}