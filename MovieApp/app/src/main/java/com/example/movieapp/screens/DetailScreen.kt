package com.example.movieapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movieapp.models.getAllMovies
import com.example.movieapp.ui.theme.DarkColor
import com.example.movieapp.ui.theme.OrangeColor
import com.example.movieapp.ui.theme.WhiteColor

@Composable
fun DetailScreen(
    navController: NavController,
    movieID: String?
){
    val newMovieList = getAllMovies().filter {
        movie ->  movie.id == movieID
    }
    Surface(
        modifier =
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
        ,
        color = DarkColor
    )
    {
        Column {
            Box(
                modifier =
                Modifier
                    .fillMaxSize()
            ){
                Box(
                    modifier =
                    Modifier
                        .height(500.dp)
                        .fillMaxWidth()
                ){
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(newMovieList[0].img)
                            .crossfade(true)
                            .build(),
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(shape = CircleShape.copy(all = CornerSize(5.dp))),
                        contentScale = ContentScale.Crop,
                        alpha = 0.5f,
                        contentDescription = "movie image"
                    )
                }
                Surface(
                    modifier = Modifier
                        .height(60.dp)
                        .width(60.dp)
                        .padding(10.dp)
                    ,
                    color = WhiteColor.copy(alpha = 0.5f),
                    shape = CircleShape
                ){
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription =""
                        )
                    }
                }
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 400.dp),
                    color = DarkColor.copy(alpha = 0.8f)
                ) {
                    Column(
                        modifier = Modifier.padding( horizontal = 15.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(top = 60.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ){
                            Text(
                                text = newMovieList[0].title,
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    color = WhiteColor
                                )
                            )
                            Row {
                                Icon(Icons.Default.Star, contentDescription ="",tint = OrangeColor)
                                Icon(Icons.Default.Star, contentDescription ="", tint = OrangeColor)
                                Icon(Icons.Default.Star, contentDescription ="",tint = OrangeColor)
                                Icon(Icons.Outlined.Star, contentDescription ="", tint = OrangeColor)
                                Icon( Icons.Outlined.Star, contentDescription ="",tint = OrangeColor)
                            }
                        }
                        Spacer(Modifier.height(20.dp))
                        Row {
                            Text(
                                text = newMovieList[0].genres.toString(),
                                style = TextStyle(
                                    color = WhiteColor,
                                    fontSize = 14.sp
                                )
                            )
                        }
                        Spacer(Modifier.height(20.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Button(
                                modifier = Modifier.height(50.dp),
                                onClick = { },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = WhiteColor
                                )
                            ) {
                                Row {
                                    Icon(
                                        Icons.Default.PlayArrow,
                                        contentDescription = "",
                                        tint =  Color.Black
                                        )
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Text(
                                        text = "Play Now",
                                        style = TextStyle(
                                            color = Color.Black,
                                            fontSize = 14.sp
                                        )
                                    )
                                }
                            }
                            OutlinedButton(
                                modifier = Modifier.height(50.dp),
                                onClick = {  },
                            ) {
                                Row {
                                    Icon(
                                        Icons.Default.KeyboardArrowDown,
                                        contentDescription = "",
                                        tint =  WhiteColor
                                        )
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Text(
                                        text = "Download",
                                        style = TextStyle(
                                            color = WhiteColor,
                                            fontSize = 14.sp
                                        )
                                    )
                                }
                            }
                        }
                        Spacer(Modifier.height(30.dp))
                        Text(
                            text = "Description",
                            style = TextStyle(
                                color = WhiteColor,
                                fontSize = 18.sp
                            )
                        )
                        Spacer(Modifier.height(10.dp))
                        Text(
                            text = newMovieList[0].description,
                            style = TextStyle(
                                color = WhiteColor,
                                fontSize = 14.sp
                            )
                        )
                        Spacer(Modifier.height(30.dp))
                        Text(
                            text = "Casts & Crews",
                            style = TextStyle(
                                color = WhiteColor,
                                fontSize = 20.sp
                            )
                        )
                    }
                }
            }
        }
    }
}

