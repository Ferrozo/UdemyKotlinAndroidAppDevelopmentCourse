package com.example.capstoneapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capstoneapp.ui.theme.OrangeColor
import com.example.capstoneapp.ui.theme.TextGrayColor

@Composable
fun CategoryMenu(
    listOfCategory: List<String>,
    currentIndex: MutableIntState
){

    LazyRow {
        items(listOfCategory.size){
            TextButton(
               modifier = Modifier.padding(start = 10.dp),
                onClick = {
                    currentIndex.intValue = it
                },
            ) {
                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = listOfCategory[it],
                        style = TextStyle(
                            fontSize = if(it == currentIndex.intValue ) 16.sp else 14.sp,
                            color = if(it == currentIndex.intValue ) Color.Black else TextGrayColor,
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    if(it == currentIndex.intValue)
                        Divider(
                            modifier = Modifier
                                .width(50.dp)
                                .height(3.dp), color = OrangeColor
                        )
                }
            }
        }
    }

}