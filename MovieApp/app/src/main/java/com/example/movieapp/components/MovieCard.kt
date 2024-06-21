package com.example.movieapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movieapp.R
import com.example.movieapp.models.MovieModel
import com.example.movieapp.ui.theme.DarkColor
import com.example.movieapp.ui.theme.OrangeColor
import com.example.movieapp.ui.theme.WhiteColor

@Composable
fun MovieCard(
    movie: MovieModel,
    isOnMiddle: Boolean
){
    Surface(
        color = Color.Transparent,
        modifier = Modifier
            .height(if(isOnMiddle) 200.dp else 180.dp)
            .width(if(isOnMiddle) 135.dp else 145.dp)
        ,
        border = BorderStroke(width = 1.dp, color = WhiteColor.copy(alpha = 0.7f)),
        shape = CircleShape.copy(all = CornerSize(5.dp)),
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(movie.img)
                .crossfade(true)
                .build(),
            modifier = Modifier
                .fillMaxSize()
                .clip(shape =CircleShape.copy(all = CornerSize(5.dp))),
            contentScale = ContentScale.Crop,
            alpha = 0.5f,
            contentDescription = "movie image"
        )
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = DarkColor.copy(0.4f),
        ){

        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top =  if(isOnMiddle) 170.dp else 150.dp, start = 10.dp)
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