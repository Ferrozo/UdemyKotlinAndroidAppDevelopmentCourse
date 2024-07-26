package com.example.weatherforecastapp.screens.intro

import android.Manifest
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weatherforecastapp.R
import com.example.weatherforecastapp.navigation.AppScreens
import com.example.weatherforecastapp.ui.theme.BlackColor
import com.example.weatherforecastapp.ui.theme.DarkGray
import com.example.weatherforecastapp.ui.theme.WhiteColor
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun IntroScreen(
    navController: NavController
){
    val locationPermissionState = rememberPermissionState(permission = Manifest.permission.ACCESS_FINE_LOCATION)
    Surface(
        modifier = Modifier
            .fillMaxSize(),
       color = BlackColor
    ) {
        Column{
            Surface(
                modifier = Modifier
                    .width(290.dp)
                    .height(280.dp)
                ,
                shape = CircleShape.copy(
                    topStart = CornerSize(0.dp),
                    topEnd = CornerSize(250.dp),
                    bottomEnd = CornerSize(250.dp), bottomStart = CornerSize(120.dp)),
                color = DarkGray.copy(alpha = 0.65f)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.weathercolored),
                        contentDescription = "",
                        modifier = Modifier.size(130.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text="KARITA",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 35.sp,
                            color = WhiteColor
                        )
                    )
                    Text(
                        text="WEATHER FORECAST",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = WhiteColor
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                Text(
                    text="TRUSTED",
                    style = TextStyle(
                        fontWeight = FontWeight.Black,
                        fontSize = 45.sp,
                        color = WhiteColor
                    )
                )
                Text(
                    text="WEATHER",
                    style = TextStyle(
                        fontWeight = FontWeight.Black,
                        fontSize = 45.sp,
                        color = WhiteColor
                    )
                )
                Text(
                    text="FORECAST",
                    style = TextStyle(
                        fontWeight = FontWeight.Black,
                        fontSize = 45.sp,
                        color = WhiteColor
                    )
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text="Get to know your weather maps \nand radar precipitation forecast",
                    style = TextStyle(
                        fontSize = 15.sp,
                        color = Color.Gray
                    )
                )
                Column(
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 40.dp),

                ) {
                    Button(
                        modifier = Modifier
                            .height(70.dp)
                            .fillMaxWidth()
                        ,
                        colors =  ButtonDefaults.buttonColors(
                            containerColor = WhiteColor
                        ),
                        shape = CircleShape.copy(all = CornerSize(10.dp)),
                        onClick = {
                            when {
                                locationPermissionState.status.isGranted -> {
                                    navController.navigate(AppScreens.HomeScreen.name){
                                        popUpTo(navController.graph.id) { inclusive = true }
                                    }
                                }
                                locationPermissionState.status.shouldShowRationale -> {
                                    locationPermissionState.launchPermissionRequest()
                                }
                                else -> {
                                    locationPermissionState.launchPermissionRequest()
                                }
                            }
                        }
                    ) {
                        Text(
                            text = "GET STARTED",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = BlackColor
                            )
                            )
                    }
                }
            }
        }
    }
}