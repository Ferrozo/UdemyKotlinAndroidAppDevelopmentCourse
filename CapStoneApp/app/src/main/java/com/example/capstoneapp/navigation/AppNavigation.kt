package com.example.capstoneapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.capstoneapp.screens.SplashScreen
import com.example.capstoneapp.screens.detail.DetailScreen
import com.example.capstoneapp.screens.home.HomeScreen
import com.example.capstoneapp.screens.login.LoginScreen
import com.example.capstoneapp.screens.reading.ReadingScreen
import com.example.capstoneapp.screens.search.SearchScreen
import com.example.capstoneapp.screens.update.UpdateScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.name) {
        composable(AppScreens.SplashScreen.name){
            SplashScreen(navController = navController)
        }
        composable(AppScreens.HomeScreen.name){
            HomeScreen(navController = navController)
        }
        composable(AppScreens.DetailScreen.name){
            DetailScreen(navController = navController)
        }
        composable(AppScreens.ReadingScreen.name){
            ReadingScreen(navController = navController)
        }
        composable(AppScreens.UpdateScreen.name){
            UpdateScreen(navController = navController)
        }
        composable(AppScreens.SearchScreen.name){
            SearchScreen(navController = navController)
        }
    }
}