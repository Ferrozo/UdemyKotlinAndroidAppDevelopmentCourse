package com.example.weatherforecastapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherforecastapp.screens.home.HomeScreen
import com.example.weatherforecastapp.screens.home.HomeViewModel
import com.example.weatherforecastapp.screens.splash.SplashScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.name ) {
        composable(AppScreens.SplashScreen.name){
            SplashScreen(navController =navController)
        }
        composable(AppScreens.HomeScreen.name){
            val homeViewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(navController = navController, homeViewModel = homeViewModel)
        }
    }
}