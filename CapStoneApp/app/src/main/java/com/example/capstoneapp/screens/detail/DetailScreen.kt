package com.example.capstoneapp.screens.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.capstoneapp.components.OrangeButton

//@Preview
@Composable
fun DetailScreen(
    navController: NavController
){
   Scaffold(
       topBar = {

       },
       bottomBar = {
           OrangeButton(title = "Start Reading", onClick = {})
       }
   ) {
       Surface(
           modifier = Modifier.padding(it)
       ) {

       }
   }
}