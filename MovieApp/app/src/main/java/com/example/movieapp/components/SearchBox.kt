package com.example.movieapp.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.R
import com.example.movieapp.ui.theme.DarkColor
import com.example.movieapp.ui.theme.WhiteColor

@Composable
fun SearchBox(
    modifier: Modifier =Modifier,
    value : MutableState<String>,
    onChangedValue: (String)-> Unit,
){
    OutlinedTextField(
        modifier = modifier,
        value = value.value,
            onValueChange = onChangedValue,
        textStyle = TextStyle(
            color = WhiteColor
        ),
        prefix = {
                 Icon(
                     painter = painterResource(R.drawable.search),
                     contentDescription = "Search icon",
                     tint = WhiteColor,
                     modifier = Modifier.size(15.dp)
                 )
        },
        suffix = {
            Icon(
                painter = painterResource(R.drawable.microphone),
                contentDescription = "Search icon",
                tint = WhiteColor,
                modifier = Modifier.size(20.dp)
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
            focusedIndicatorColor = WhiteColor.copy(alpha = 0.5f),
            focusedTextColor = WhiteColor,
        ),
        singleLine = true,
    )
}
