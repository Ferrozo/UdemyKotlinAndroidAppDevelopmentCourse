package com.example.movieapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movieapp.MyApp
import com.example.movieapp.R
import com.example.movieapp.models.MovieModel
import com.example.movieapp.ui.theme.DarkColor
import com.example.movieapp.ui.theme.OrangeColor
import com.example.movieapp.ui.theme.WhiteColor

@Composable
fun MovieSliderCard(
    movie: MovieModel
){
    Surface(
        color = Color.Black.copy(alpha = 0.7f),
        modifier = Modifier
            .height(200.dp)
            .padding(horizontal = 15.dp)
        ,
        border = BorderStroke(width = 1.dp, color = WhiteColor.copy(alpha = 0.7f)),
        shape = CircleShape.copy(all = CornerSize(5.dp)),
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .clip(
                    shape =
                    CircleShape.copy(all = CornerSize(5.dp))
                )
            ,
            contentScale = ContentScale.Crop,
            model  = ImageRequest.Builder(LocalContext.current)
            .data(movie.img)
            .crossfade(true)
            .build(),
            contentDescription = "Artist image")
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = DarkColor.copy(0.5f),
        ){

        }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 170.dp, start = 10.dp)
    ) {

            Surface(
                modifier = Modifier
                    .height(20.dp)
                    .width(50.dp),
                color = OrangeColor,
                shape = CircleShape.copy(all = CornerSize(2.dp))
            ){
                Text(
                    modifier = Modifier.padding(4.5.dp),
                    text = "IMDB 4.9",
                    style = TextStyle(
                        fontSize = 10.sp,
                    )
                )
            }
        }
    }
}