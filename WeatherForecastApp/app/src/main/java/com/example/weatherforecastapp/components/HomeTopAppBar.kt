package com.example.weatherforecastapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weatherforecastapp.navigation.AppScreens
import com.example.weatherforecastapp.screens.home.HomeViewModel
import com.example.weatherforecastapp.ui.theme.WhiteColor
import com.google.gson.Gson

@Composable
fun HomeTopAppBar(
    navController: NavController,
    homeViewModel: HomeViewModel
){
    val value = remember { mutableStateOf("") }
    val showDialog = remember { mutableStateOf(false) }
    val dialogText = "Make sure you have a valid city name and try again"

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp)
        ,
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "City List",
            style = TextStyle(
                color = WhiteColor,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        SearchBox(
            value= value.value,
            onValueChange = {value.value = it},
            navController = navController,
            onSearch = { city ->
                homeViewModel.searchWeather(city) { result ->
                    if (result.data != null) {
                        val weatherJson = Gson().toJson(result.data)
                        navController.navigate("${AppScreens.DetailScreen.name}/$weatherJson")
                    } else {
                        showDialog.value = true
                    }
                }
            }
        )
    }

    if (showDialog.value) {
        AlertDialogExample(
            onDismissRequest = { showDialog.value = false },
            dialogText = dialogText
        )
    }
}