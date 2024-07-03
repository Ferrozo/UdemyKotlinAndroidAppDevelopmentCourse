package com.example.noteapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.noteapp.NoteViewModel
import com.example.noteapp.screens.HomeScreen
import dagger.hilt.android.AndroidEntryPoint


@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.HomeScreen.name
    ){
        composable(AppScreens.HomeScreen.name){
            HomeScreen()
        }
//
//        composable(
//            AppScreens.DetailScreen.name+"/{noteID}",
//            arguments = listOf(navArgument(name = "noteID"){type= NavType.StringType}),
//        ){backStackEntry ->
//            AppScreens.DetailScreen(
//                navController = navController,
//                backStackEntry.arguments?.getString("noteID")
//            )
//        }
//
//        composable(AppScreens.AddNoteScreen.name){
//            SearchScreen(navController = navController)
//        }
    }

}