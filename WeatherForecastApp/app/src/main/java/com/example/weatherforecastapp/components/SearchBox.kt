package com.example.weatherforecastapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weatherforecastapp.R
import com.example.weatherforecastapp.ui.theme.WhiteColor

@Composable
fun SearchBox(
    text: String = " Search for a city or airport",
    onValueChange: (String) -> Unit = {},
    navController: NavController
){
    TextField(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth(),
        shape = CircleShape.copy(all = CornerSize(10.dp)),
        colors =   TextFieldDefaults.colors(
            focusedTextColor =  Color.Gray.copy(alpha = 0.5f),
            focusedContainerColor = Color.Gray.copy(alpha = 0.2f),
            unfocusedContainerColor = Color.Gray.copy(alpha = 0.2f),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        textStyle =  TextStyle(
            color = WhiteColor.copy(alpha = 0.7f),
            fontSize = 14.sp,
        ),
        prefix = {
                if(text.isEmpty()){
                    Icon(
                        painterResource(id = R.drawable.search),
                        contentDescription = null,
                        tint = WhiteColor.copy(alpha = 0.7f),
                        modifier = Modifier.size(20.dp)
                    )
                } else {
                     Icon(
                         Icons.Default.ArrowBack,
                            contentDescription = null,
                            tint = WhiteColor.copy(alpha = 0.7f),
                            modifier = Modifier
                                .size(20.dp)
                                .clickable {
                                navController.popBackStack()
                            }
                     )
                }
        },
        value = text,
        onValueChange = onValueChange
    )
}