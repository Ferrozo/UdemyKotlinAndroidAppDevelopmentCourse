package com.example.weatherforecastapp.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weatherforecastapp.R
import com.example.weatherforecastapp.navigation.AppScreens
import com.example.weatherforecastapp.ui.theme.BlackColor
import com.example.weatherforecastapp.ui.theme.WhiteColor
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    
    LaunchedEffect(key1 = true) {
        scale.animateTo(0.9f, animationSpec = tween(
            durationMillis = 800,
            easing = {
                OvershootInterpolator(8f).getInterpolation(it)
            }
        ))
        delay(timeMillis = 5000L)
        navController.navigate(AppScreens.IntroScreen.name){
            popUpTo(navController.graph.startDestinationId) { inclusive = true }
        }
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = BlackColor
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .scale(scale.value)
            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painterResource(id = R.drawable.weatherforecast),
                tint = WhiteColor,
                contentDescription = "logo",
                modifier = Modifier.size(100.dp)
            )
        }
    }
}