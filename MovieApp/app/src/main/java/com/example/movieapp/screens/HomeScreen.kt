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
import com.example.movieapp.components.Decorator
import com.example.movieapp.components.MovieCard
import com.example.movieapp.components.MovieSliderCard
import com.example.movieapp.components.OutlineBtn
import com.example.movieapp.components.SearchBox
import com.example.movieapp.models.MovieModel
import com.example.movieapp.ui.theme.DarkColor
import com.example.movieapp.ui.theme.OrangeColor
import com.example.movieapp.ui.theme.WhiteColor

@Composable
fun HomeScreen(
    navController: NavController
){
    val movies: List<MovieModel> = listOf(
        MovieModel(
            title = "Joker",
            genres = listOf("Crime","Drama", "Thriller"),
            description = "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
            director = "Todd Phillips" ,
            img = "https://imageio.forbes.com/specials-images/imageserve/5d6a0922fead28000892b2b7/Official-poster-for-Warner-s--Joker-/960x0.jpg?format=jpg&width=1440",
            actors = listOf("Joaquin Phoenix", "Zazie Beetz", "Robert De Niro", "Brett Cullen"),
            rating = 8.4
        ),
        MovieModel(
            title = "Batman Under The Blood Hood",
            genres = listOf("Animation","Action","Crime", "Drama"),
            description = "When a sadistic serial killer begins murdering key political figures in Gotham, The Batman is forced to investigate the city's hidden corruption and question his family's involvement.",
            director = "Matt Reeves" ,
            img = "https://ntvb.tmsimg.com/assets/p8129393_v_h10_ab.jpg?w=1280&h=720",
            actors = listOf("Bruce Greenwood", "John DiMaggio", "Jensen Ackles", "Jason Isaacs"),
            rating = 7.8
        ),
        MovieModel(
            title = "Damsel",
            genres = listOf("Action","Crime", "Drama"),
            description = "A young woman agrees to marry a handsome prince -- only to discover it was all a trap. She is thrown into a cave with a fire-breathing dragon and must rely solely on her wits and will to survive.",
            director = "Juan Carlos Fresnadillo" ,
            img = "https://m.media-amazon.com/images/M/MV5BODRiMTA4NGMtOTQzZC00OWFjLWFmODctMjY2ZTcwYjI5NDMyXkEyXkFqcGdeQXVyMDc5ODIzMw@@._V1_FMjpg_UX1000_.jpg",
            actors = listOf("Millie Bobby Brown", "Angela Bassett", "Nick Robinson", "Milo Twomey"),
            rating = 7.8
        ),
        MovieModel(
            title = "Rebel Moon",
            genres = listOf("Action","Crime", "Drama"),
            description = "A colony on the edge of the galaxy fights for survival against a tyrannical ruling force, relying on the efforts of a small group of rebel.",
            director = "Zack Snyder" ,
            img = "https://upload.wikimedia.org/wikipedia/en/d/dd/Rebel_Moon_%E2%80%93_Part_Two_The_Scargiver_poster.jpg",
            actors = listOf("Sofia Boutella", "Djimon Hounsou", "Ed Skrein", "Michiel Huisman"),
            rating = 7.8
        ),
        MovieModel(
            title = "Lift",
            genres = listOf("Action","Crime", "Drama"),
            description = "A master thief is wooed by his ex-girlfriend and the FBI to pull off an impossible heist with his international crew on a 777 passenger flight from London to Zurich.",
            director = "Matt Reeves" ,
            img = "https://upload.wikimedia.org/wikipedia/en/c/c0/Lift_2024_poster.webp",
            actors = listOf("Kevin Hart", "Gugu Mbatha-Raw", "Sam Worthington", "Yun Jee Kim"),
            rating = 7.8
        ),
        MovieModel(
            title = "Atlas",
            genres = listOf("Action","Crime", "Drama", "Sci-fi"),
            description = "A brilliant data analyst with a deep distrust of AI finds it may be her only hope when a mission to capture a renegade robot goes awry.",
            director = "Brad Peyton" ,
            img = "https://upload.wikimedia.org/wikipedia/en/f/f4/Atlas_2024_film_poster.png",
            actors = listOf("Jennifer Lopez", "Sterling K. Brown", "Lana Parrilla", "Ashley J. Hicks"),
            rating = 7.8
        ),
    )
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
                           isOnMiddle = if(it == 3 ) true else false
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
                            isOnMiddle = false
                        )
                    }
                }
            }
        }


}

@Composable
@Preview(showBackground = true)
fun HomePreview(){
    MainContent(
        movieList = listOf(MovieModel(title = "", img = "", genres = listOf(""), description = "", actors = listOf(""), rating = 4.0, director = "")),
        navController = rememberNavController(),
    )
}

