package com.example.movieapp.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Decorator(color: Color){
    Surface(
        color = color,
        modifier= Modifier
            .height(10.dp)
            .width(10.dp),
        shape = CircleShape
    ) {

    }
}