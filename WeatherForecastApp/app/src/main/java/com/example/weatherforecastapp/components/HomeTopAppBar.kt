package com.example.weatherforecastapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weatherforecastapp.ui.theme.DarkGray
import com.example.weatherforecastapp.ui.theme.WhiteColor

@Composable
fun HomeTopAppBar(
    navController: NavController
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp)

        ,
    ) {
        Text(
            text = "City List",
            style = TextStyle(
                color = WhiteColor,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Light rain for the next hour",
            style = TextStyle(
                color = Color.Gray.copy(alpha = 0.5f),
                fontSize = 14.sp,
                )
        )
        Spacer(modifier = Modifier.height(10.dp))
        SearchBox(navController = navController)
    }
}