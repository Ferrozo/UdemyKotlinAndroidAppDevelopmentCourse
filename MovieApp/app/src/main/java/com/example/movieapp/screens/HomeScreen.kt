package com.example.movieapp.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.movieapp.models.MovieModel

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
            title = "Batman Under The Blood Hood",
            genres = listOf("Animation","Action","Crime", "Drama"),
            description = "When a sadistic serial killer begins murdering key political figures in Gotham, The Batman is forced to investigate the city's hidden corruption and question his family's involvement.",
            director = "Matt Reeves" ,
            img = "https://ntvb.tmsimg.com/assets/p8129393_v_h10_ab.jpg?w=1280&h=720",
            actors = listOf("Bruce Greenwood", "John DiMaggio", "Jensen Ackles", "Jason Isaacs"),
            rating = 7.8
        ),
    )
    MainContent(movieList = movies,
        navController = navController
    )
}

@Composable
fun MainContent(
    movieList: List<MovieModel>,
    navController: NavController,
    ) {


}

