package com.example.bizcardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bizcardapp.ui.theme.BizCardAppTheme
import com.example.bizcardapp.ui.theme.DarkBackgroundColor
import com.example.bizcardapp.ui.theme.WhiteGrayColor
import com.example.bizcardapp.widgets.Categories
import com.example.bizcardapp.widgets.HeaderBox
import com.example.bizcardapp.widgets.PortfolioCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BizCardAppTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp(){
    val scrollState = rememberScrollState()
    Scaffold(
        containerColor = DarkBackgroundColor,
        modifier = Modifier.fillMaxSize()

    ) {
        Column(
            modifier = Modifier.
            verticalScroll(scrollState)
                .padding(
                    horizontal = 5.dp,
                    vertical = 10.dp,
                )
        ) {
            HeaderBox(
                modifier = Modifier.padding(it)
            )
            Categories(
                color =WhiteGrayColor.copy(alpha = 0.1f)
            )
            Box(Modifier.height(20.dp))
            PortfolioCard(
                title = "Dating App",
                description = "Flutter/Dart",
                image =  painterResource(id = R.drawable.dating),

                )
            Box(Modifier.height(10.dp))
            PortfolioCard(
                title = "Ecommerce \nApp",
                description = "Flutter/Dart",
                image =  painterResource(id = R.drawable.ecomerce),

                )
            Box(Modifier.height(10.dp))
            PortfolioCard(
                title = "Todo App",
                description = "Flutter/Dart",
                image =  painterResource(id = R.drawable.todo),
            )
            Box(Modifier.height(10.dp))
            PortfolioCard(
                title = "Todo App",
                description = "Flutter/Dart",
                image =  painterResource(id = R.drawable.todo),
                )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BizCardAppTheme {
        MyApp()
    }
}