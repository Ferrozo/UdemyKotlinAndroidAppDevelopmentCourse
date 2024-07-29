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
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
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
    value: String,
    onValueChange: (String) -> Unit = {},
    navController: NavController,
    onSearch: (String) -> Unit = {},
){
    TextField(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth(),
        shape = CircleShape.copy(all = CornerSize(10.dp)),
        placeholder = {
                      Text(text =" Search for a city")
        },
        colors =   TextFieldDefaults.colors(
            focusedTextColor =  Color.Gray.copy(alpha = 0.5f),
            focusedContainerColor = Color.Gray.copy(alpha = 0.2f),
            unfocusedContainerColor = Color.Gray.copy(alpha = 0.2f),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        singleLine = true,
        textStyle =  TextStyle(
            color = WhiteColor.copy(alpha = 0.7f),
            fontSize = 18.sp,
        ),
        prefix = {
                if(value.trim().isEmpty()){
                    Icon(
                        painterResource(id = R.drawable.search),
                        contentDescription = null,
                        tint = WhiteColor.copy(alpha = 0.7f),
                        modifier = Modifier.size(20.dp)
                    )
                } else {
                     Icon(
                         Icons.Default.Clear,
                            contentDescription = null,
                            tint = WhiteColor.copy(alpha = 0.7f),
                            modifier = Modifier
                                .size(20.dp)
                                .clickable {
                                    onValueChange("")
                            }
                     )
                }
        },
        suffix = {
            if(value.trim().isNotEmpty()){
                Icon(
                    Icons.Default.ArrowForward,
                    contentDescription = null,
                    tint = WhiteColor.copy(alpha = 0.7f),
                    modifier = Modifier.size(20.dp)
                        .clickable {
                            onSearch(value)
                        }

                )
            }
        },
        value = value,
        onValueChange = onValueChange
    )
}