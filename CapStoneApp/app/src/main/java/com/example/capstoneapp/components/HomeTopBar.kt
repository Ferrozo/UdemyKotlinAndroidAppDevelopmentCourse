package com.example.capstoneapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capstoneapp.R
import com.example.capstoneapp.ui.theme.DarkBlueColor
import com.example.capstoneapp.ui.theme.TextGrayColor

@Composable
fun HomeTopBar(){
    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        IconButton(
            modifier = Modifier
                .padding(0.dp)
                .border(
                    border = BorderStroke(width = 1.5.dp, color = TextGrayColor),
                    shape = CircleShape
                )
                .size(55.dp),
            onClick = { /*TODO*/ },
        ) {
            Icon(
                Icons.Default.List,
                contentDescription = "",
                tint = DarkBlueColor,
                modifier = Modifier.size(25.dp)
            )
        }
        Text(
            text= "Karita.reader",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Black,
                color = DarkBlueColor
            )
        )
        IconButton(
            modifier = Modifier
                .padding(0.dp)
                .border(
                    border = BorderStroke(width = 1.5.dp, color = TextGrayColor),
                    shape = CircleShape
                )
                .size(55.dp),
            onClick = { /*TODO*/ },
            ) {
            Icon(
                painter = painterResource(id = R.drawable.notification),
                contentDescription = "",
                tint = DarkBlueColor,
                modifier = Modifier.size(25.dp)
            )
        }
    }
}