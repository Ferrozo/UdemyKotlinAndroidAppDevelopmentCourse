package com.example.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movieapp.navigation.AppNavigation
import com.example.movieapp.ui.theme.DarkColor
import com.example.movieapp.ui.theme.MovieAppTheme

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
