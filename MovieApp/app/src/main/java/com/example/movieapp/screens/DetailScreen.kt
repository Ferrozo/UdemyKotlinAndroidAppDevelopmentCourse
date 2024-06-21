package com.example.movieapp.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.movieapp.ui.theme.DarkColor

@Composable
fun DetailScreen(
    navController: NavController,
    movieData: String?
){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = DarkColor
    )
    {

    }
}