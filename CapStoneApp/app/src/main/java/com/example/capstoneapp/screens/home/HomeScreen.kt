package com.example.capstoneapp.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.capstoneapp.components.BookCard
import com.example.capstoneapp.components.BottomBar
import com.example.capstoneapp.components.CategoryMenu
import com.example.capstoneapp.components.HomeTopBar
import com.example.capstoneapp.components.SearchBox
import com.example.capstoneapp.components.TrendCard
import com.example.capstoneapp.navigation.AppScreens
import com.example.capstoneapp.ui.theme.BackgroundColor
import com.example.capstoneapp.ui.theme.TextGrayColor

@Composable
fun HomeScreen(navController: NavController){

    val categoryList  =listOf("Trending", "Cartoon", "Romance", "Action", "Comedy")

    val currentIndex = remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        bottomBar = {
            BottomBar()
        },
        modifier = Modifier.fillMaxSize()) { it ->
        Surface( modifier =
        Modifier
            .padding(it)
            .fillMaxSize(),
            color = BackgroundColor
        ) {
            Column (
                modifier = Modifier
                    .verticalScroll(state = rememberScrollState())
                    .fillMaxSize(),
                ){
                Spacer(modifier = Modifier.height(20.dp))
                HomeTopBar()
                Spacer(modifier = Modifier.height(30.dp))
                SearchBox(
                    value = "",
                    onValueChange = {},
                    enabled= false,
                    onClick = {navController.navigate(AppScreens.SearchScreen.name)},
                    onSearch = {}
                )
                Spacer(modifier = Modifier.height(20.dp))
                CategoryMenu(
                    listOfCategory = categoryList,
                    currentIndex = currentIndex
                )
                Spacer(modifier = Modifier.height(20.dp))
                TrendCard()
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                  Text(
                      text = "Most Popular",
                      style = TextStyle(
                          fontSize = 20.sp,
                          fontWeight = FontWeight.Bold,
                          color = Color.Black
                        )
                      )
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(
                            text = "View All",
                            style = TextStyle(
                                fontSize = 16.sp,
                                color = TextGrayColor
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                LazyRow {
                    item(){
                        BookCard(navController = navController)
                        BookCard(navController = navController)
                    }
                }
                Spacer(modifier = Modifier.height(60.dp))
            }
        }
    }
}