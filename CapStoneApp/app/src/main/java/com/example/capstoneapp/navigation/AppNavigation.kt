package com.example.capstoneapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.capstoneapp.screens.SplashScreen
import com.example.capstoneapp.screens.detail.DetailScreen
import com.example.capstoneapp.screens.detail.DetailViewModel
import com.example.capstoneapp.screens.home.HomeScreen
import com.example.capstoneapp.screens.login.LoginScreen
import com.example.capstoneapp.screens.login.LoginViewModel
import com.example.capstoneapp.screens.reading.ReadingScreen
import com.example.capstoneapp.screens.search.SearchBookViewModel
import com.example.capstoneapp.screens.search.SearchScreen
import com.example.capstoneapp.screens.signup.SignUpScreen
import com.example.capstoneapp.screens.signup.SignUpViewModel
import com.example.capstoneapp.screens.update.UpdateScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.name) {
        composable(AppScreens.SplashScreen.name){
            SplashScreen(navController = navController)
        }
        composable(AppScreens.HomeScreen.name){
            val viewModel = hiltViewModel<SearchBookViewModel>()
            HomeScreen(navController = navController, viewModel=viewModel )
        }
        composable(AppScreens.DetailScreen.name+"/{bookID}",
            arguments = listOf(navArgument(name = "bookID"){type= NavType.StringType}),
            ){backStackEntry ->
            val viewModel = hiltViewModel<DetailViewModel>()
            backStackEntry.arguments?.getString("bookID").let { id ->
                DetailScreen(navController = navController, bookId = id, viewModel = viewModel)
            }
        }
        composable(AppScreens.ReadingScreen.name){
            ReadingScreen(navController = navController)
        }
        composable(AppScreens.UpdateScreen.name){
            UpdateScreen(navController = navController)
        }
        composable(AppScreens.LoginScreen.name){
            val loginViewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(navController = navController, loginViewModel)
        }
        composable(AppScreens.SignUpScreen.name){
            val viewModel = hiltViewModel<SignUpViewModel>()
            SignUpScreen(navController = navController, viewModel)
        }
        composable(AppScreens.SearchScreen.name){
            val viewModel = hiltViewModel<SearchBookViewModel>()
            SearchScreen(navController = navController, viewModel = viewModel)
        }
    }
}