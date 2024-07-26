package com.example.weatherforecastapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherforecastapp.model.Weather
import com.example.weatherforecastapp.ui.theme.WhiteColor
import com.example.weatherforecastapp.util.fahrenheitToCelsius
import com.example.weatherforecastapp.util.formatDate

@Composable
fun WeatherCard(
     weather: Weather,
     onClicked: ()-> Unit,
){
    val temperatureCelsius = fahrenheitToCelsius(weather.main.temp)
    Surface(
        modifier = Modifier
            .height(130.dp)
            .fillMaxWidth()
            .clickable { onClicked()}
        ,
            shape = CircleShape.copy(all = CornerSize(20.dp)),
            color = WhiteColor.copy(alpha = 0.9f)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(20.dp),
        ) {
            Column {
                Row {
                    IconWeather(
                        image = weather.weather.first().icon,
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column{
                            Text(
                                text = weather.name,
                                style = androidx.compose.ui.text.TextStyle(
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = formatDate(weather.dt),
                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 13.sp,
                                color = Color.Gray
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = weather.weather.first().description,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            Text(
                text = "%.0f°C".format(temperatureCelsius),
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 55.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

