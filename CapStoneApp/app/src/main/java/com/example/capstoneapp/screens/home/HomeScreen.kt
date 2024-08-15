package com.example.capstoneapp.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.capstoneapp.components.HomeTopBar
import com.example.capstoneapp.components.SearchBox
import com.example.capstoneapp.navigation.AppNavigation
import com.example.capstoneapp.ui.theme.BackgroundColor


@Composable
fun HomeScreen(navController: NavController){
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Surface( modifier =
        Modifier.padding(it)
            .fillMaxSize(),
            color = BackgroundColor
        ) {
            Column (
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxSize(),

                ){
                Spacer(modifier = Modifier.height(40.dp))
                HomeTopBar()
                Spacer(modifier = Modifier.height(40.dp))
                SearchBox()
            }
        }
    }

}