package com.example.movieapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.MyApp
import com.example.movieapp.ui.theme.DarkColor
import com.example.movieapp.ui.theme.WhiteColor

@Composable
fun SearchBox(
    value : MutableState<String>,
    onChangedValue: (String)-> Unit,
){
    OutlinedTextField(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth(),
        value = value.value,
            onValueChange = onChangedValue,
        prefix = {
                 Icon(
                     imageVector = Icons.Default.Search,
                     contentDescription = "Search icon",
                     tint = WhiteColor
                 )
        },
        suffix = {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Search icon",
                tint = WhiteColor
            )
        },
        placeholder = {
                      Text(
                          text = "Finds movies, shows and more",
                          style = TextStyle(
                              fontSize = 14.sp,
                          )
                      )
        },
        shape = CircleShape.copy(all = CornerSize(20.dp)),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = DarkColor,
            focusedContainerColor = DarkColor,

        )
    )
}
