package com.example.weatherforecastapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.weatherforecastapp.model.Weather
import com.example.weatherforecastapp.screens.details.DetailScreen
import com.example.weatherforecastapp.screens.home.HomeScreen
import com.example.weatherforecastapp.screens.home.HomeViewModel
import com.example.weatherforecastapp.screens.intro.IntroScreen
import com.example.weatherforecastapp.screens.splash.SplashScreen
import com.google.gson.Gson

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.name ) {
        composable(AppScreens.SplashScreen.name){
            SplashScreen(navController =navController)
        }

        composable(AppScreens.IntroScreen.name){
            IntroScreen(navController =navController)
        }

        composable(AppScreens.HomeScreen.name){
            val homeViewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(navController = navController, homeViewModel = homeViewModel)
        }
        composable(
            "${AppScreens.DetailScreen.name}/{weather}",
            arguments = listOf(navArgument("weather") { type = NavType.StringType })
        ) { backStackEntry ->
            val weatherJson = backStackEntry.arguments?.getString("weather")
            val weather = Gson().fromJson(weatherJson, Weather::class.java)
            DetailScreen(navController = navController, weather = weather)
        }
    }
}