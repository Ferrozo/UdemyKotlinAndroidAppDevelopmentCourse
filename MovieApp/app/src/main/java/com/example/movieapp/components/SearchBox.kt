package com.example.movieapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.MyApp

@Composable
fun SearchBox(){
    OutlinedTextField(
        modifier = Modifier.
        height(50.dp)
            .fillMaxWidth(),
        value = "",
            onValueChange = {},
        colors = TextFieldDefaults.colors(

        )
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApp {
        SearchBox()
    }
}