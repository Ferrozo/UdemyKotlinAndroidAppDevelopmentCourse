package com.example.capstoneapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.capstoneapp.navigation.AppScreens
import com.example.capstoneapp.ui.theme.BackgroundColor
import com.example.capstoneapp.ui.theme.DarkBlueColor
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(timeMillis = 5000L)
        navController.navigate(AppScreens.HomeScreen.name){
            popUpTo(navController.graph.startDestinationId) { inclusive = true }
        }
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = BackgroundColor
    ) {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center

            ){
                Text("KARITA",
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Black,
                        color = DarkBlueColor
                    )
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text("Reader",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = DarkBlueColor
                    )
                )
            }
        }
    }
}