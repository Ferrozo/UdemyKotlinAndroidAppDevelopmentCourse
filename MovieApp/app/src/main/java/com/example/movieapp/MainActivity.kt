package com.example.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.navigation.AppNavigation
import com.example.movieapp.ui.theme.DarkColor
import com.example.movieapp.ui.theme.MovieAppTheme
import com.example.movieapp.ui.theme.OrangeColor
import com.example.movieapp.ui.theme.WhiteColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                MyApp {
                    AppNavigation()
                }
        }
    }
}

@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    content: @Composable ()-> Unit
) {
    MovieAppTheme {
        Scaffold(
            modifier = modifier
                .fillMaxSize(),
                containerColor = DarkColor,
        )
        { value ->
            Column(
                modifier = Modifier.padding(value)
            ){
               content()
            }
        }
    }
}
//
//@Composable
//@Preview(showBackground = true)
//fun DetailPreview(){
//    MyApp{
//        Scaffold(
//            modifier = Modifier
//                .fillMaxSize(),
//            containerColor = DarkColor,
//
//            bottomBar = {
//                BottomBar()
//            }
//        )
//        { value ->
//            Column(
//                modifier = Modifier.padding(value)
//            ){
//
//            }
//        }
//    }
//}
