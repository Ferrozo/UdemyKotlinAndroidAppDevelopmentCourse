package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.screens.DetailScreen
import com.example.movieapp.screens.HomeScreen
import com.example.movieapp.screens.SearchScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.HomeScreen.name
    ){
        composable(AppScreens.HomeScreen.name){
            HomeScreen(navController = navController)
        }

        composable(
            AppScreens.DetailScreen.name+"/{movieID}",
            arguments = listOf(navArgument(name = "movieID"){type= NavType.StringType}),
            ){backStackEntry ->
            DetailScreen(navController = navController, backStackEntry.arguments?.getString("movieID"))
        }

        composable(AppScreens.SearchScreen.name){
            SearchScreen(navController = navController)
        }
    }

}