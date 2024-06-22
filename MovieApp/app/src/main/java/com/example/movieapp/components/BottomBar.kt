package com.example.movieapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.movieapp.R
import com.example.movieapp.ui.theme.DarkColor
import com.example.movieapp.ui.theme.OrangeColor
import com.example.movieapp.ui.theme.WhiteColor


@Composable
fun BottomBar(){
    Surface(
        color = DarkColor
    ) {
        Box(
            modifier = Modifier.height(60.dp)){
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 25.dp)
                ,
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.home),
                        tint = OrangeColor,
                        contentDescription = "",
                        modifier = Modifier.size(22.dp)
                    )

                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "",
                        tint = WhiteColor,
                        modifier = Modifier.size(22.dp)
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.heart),
                        contentDescription = "",
                        tint = WhiteColor,
                        modifier = Modifier.size(22.dp)
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "",
                        tint = WhiteColor,
                        modifier = Modifier.size(22.dp)
                    )
                }
            }
        }
    }
}