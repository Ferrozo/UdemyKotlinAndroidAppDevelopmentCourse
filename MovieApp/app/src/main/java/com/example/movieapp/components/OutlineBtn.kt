package com.example.movieapp.components

import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import com.example.movieapp.ui.theme.WhiteColor

@Composable
fun OutlineBtn(
    title: String,
    onClick: ()-> Unit,
){
    OutlinedButton(
        onClick = onClick
    ) {
        Text(
            text = title,
            style = TextStyle(
                color = WhiteColor,
            )
        )
    }
}