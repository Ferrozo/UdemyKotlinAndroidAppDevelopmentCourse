package com.example.movieapp.screens

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.components.BottomBar
import com.example.movieapp.components.Decorator
import com.example.movieapp.components.MovieCard
import com.example.movieapp.components.MovieSliderCard
import com.example.movieapp.components.OutlineBtn
import com.example.movieapp.components.SearchBox
import com.example.movieapp.models.MovieModel
import com.example.movieapp.models.getAllMovies
import com.example.movieapp.navigation.AppScreens
import com.example.movieapp.ui.theme.DarkColor
import com.example.movieapp.ui.theme.OrangeColor
import com.example.movieapp.ui.theme.WhiteColor

@Composable
fun HomeScreen(
    navController: NavController
){
    val movies = getAllMovies()
    MainContent(
        movieList = movies, navController = navController
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MainContent(
    movieList: List<MovieModel>,
    navController: NavController,
    ) {
    val searchValue = remember {
        mutableStateOf(value = "")
    }
    val categoryList = listOf<String>("All", "Crime", "Drama", "Animation", "Thriller")
    Scaffold (
        bottomBar = {
            BottomBar()
        }
    ){
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = DarkColor,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 20.dp)
                    .verticalScroll(rememberScrollState()),
            ) {
                SearchBox(
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                        .height(60.dp)
                        .fillMaxWidth(),
                    value = searchValue,
                    onChangedValue = {
                        searchValue.value = it
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))
                MovieSliderCard(
                    movie = movieList[3]
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                {
                    Decorator(color = OrangeColor)
                    Spacer(modifier = Modifier.width(10.dp))
                    Decorator(color = WhiteColor.copy(alpha = 0.5f))
                    Spacer(modifier = Modifier.width(10.dp))
                    Decorator(color = WhiteColor.copy(alpha = 0.5f))
                }
                Spacer(modifier = Modifier.height(20.dp))
                LazyRow(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                {
                    items(count = categoryList.size) {
                        OutlineBtn(
                            title = categoryList[it],
                            onClick = {

                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                ){
                    Text(
                        text = "Trending Now",
                        style = TextStyle(
                            color = WhiteColor,
                            fontSize = 18.sp,
                        )
                    )
                    TextButton(
                        onClick = {}
                    ){
                        Text(
                            text = "View all",
                            style = TextStyle(
                                color = OrangeColor,
                                fontSize = 12.sp,
                                textDecoration = TextDecoration.Underline
                            )
                        )
                    }

                }
                Spacer(modifier = Modifier.height(15.dp))
                LazyRow(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ){
                    items(
                        count = movieList.size
                    ){
                        MovieCard(
                            movie = movieList[it],
                            isOnMiddle = if(it == 3 ) true else false,
                            onMovieClick = {
                                navController.navigate(AppScreens.DetailScreen.name+"/${movieList[it].id}")
                            }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                ){
                    Text(
                        text = "All Categories",
                        style = TextStyle(
                            color = WhiteColor,
                            fontSize = 18.sp,
                        )
                    )

                }
                Spacer(modifier = Modifier.height(15.dp))
                FlowRow (
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    maxItemsInEachRow = 2
                ) {
                    repeat(
                        times = movieList.size,
                    ){
                        MovieCard(
                            movie = movieList[it],
                            isOnMiddle = false,
                            onMovieClick = {
                                navController.navigate(AppScreens.DetailScreen.name+"/${movieList[it].id}")
                            }
                        )
                    }
                }
            }
        }
    }
}
