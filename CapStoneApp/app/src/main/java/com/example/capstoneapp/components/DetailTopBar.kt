package com.example.capstoneapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.capstoneapp.R
import com.example.capstoneapp.ui.theme.DarkBlueColor

@Composable
fun DetailTopBar(
    navController: NavController,
){
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        CircularOutlinedButton(
            icon =  painterResource(id = R.drawable.arrow_back),
            onClick = { navController.popBackStack()},
        )
        Text(
            text= "Detail",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Black,
                color = DarkBlueColor
            )
        )
        CircularOutlinedButton(
            icon = painterResource(id = R.drawable.list),
            onClick = {  },
        )

    }
}