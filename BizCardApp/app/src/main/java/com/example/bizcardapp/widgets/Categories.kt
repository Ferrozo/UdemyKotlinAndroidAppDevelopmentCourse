package com.example.bizcardapp.widgets

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun Categories  (
    color : Color,
){
    val scrollState = rememberScrollState()
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(scrollState, enabled = true,),
        horizontalArrangement = Arrangement.SpaceAround
    ){
        Button(
            modifier = Modifier
                .height(50.dp)
                .padding(5.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = color,
            ),
            onClick = { }
        ) {
            Text(text= "All")
        }
        Button(
            modifier = Modifier
                .height(50.dp)
                .padding(5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = color,
            ),
            onClick = { }
        ) {
            Text(text= "Kotlin")
        }
        Button(

            modifier = Modifier
                .height(50.dp)
                .padding(5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = color,
            ),
            onClick = { }
        ) {
            Text(text= "Flutter")
        }
        Button(
            modifier = Modifier
                .height(50.dp)
                .padding(5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = color,
            ),
            onClick = { }
        ) {
            Text(text= "Design")
        }
    }

}