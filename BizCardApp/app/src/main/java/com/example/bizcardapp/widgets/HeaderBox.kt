package com.example.bizcardapp.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bizcardapp.R
import com.example.bizcardapp.ui.theme.DarkBackgroundColor80
import com.example.bizcardapp.ui.theme.WhiteGrayColor

@Composable
fun HeaderBox(
     modifier: Modifier = Modifier,
){
    Surface (
        color = DarkBackgroundColor80,
        modifier = modifier
            .height(height = 200.dp)
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        shape  = RoundedCornerShape( 40.dp),
    ) {
        Column(
            modifier = Modifier.padding(15.dp,)
        ) {
            Row(
               horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            )
            {
                Row {
                    Surface(
                        modifier = Modifier
                            .height(60.dp)
                            .width(60.dp),
                        shape = CircleShape
                    )
                    {
                        Image(
                            modifier = Modifier
                                .size(20.dp)
                                .padding(3.dp)
                                .clip(CircleShape)
                            ,
                            painter = painterResource(id = R.drawable.user),
                            contentDescription = "user profile"
                        )
                    }
                    Box(modifier = modifier.width(15.dp))
                    Column {
                        Text(
                            text = "Good to see you again",
                            style = TextStyle(
                                fontSize = 12.sp,
                                color = WhiteGrayColor.copy(alpha = 0.7f)
                                )
                            )
                        Box(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Wilson Ferrozo",
                            style =
                            TextStyle(
                                fontWeight = FontWeight.Bold,
                                color = WhiteGrayColor,
                                fontSize = 20.sp
                             )
                            )
                    }
                }
                Icon(
                    painter = painterResource(
                        id = R.drawable.qr_code,
                    ),
                    tint = WhiteGrayColor,
                    contentDescription = "QR CODE",
                    modifier = Modifier
                        .size(30.dp)
                        .padding(5.dp)
                )
            }
            TextField(
                                label = {
                        Text(text = "Search")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                shape = CircleShape,
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = WhiteGrayColor.copy(alpha = 0.1f),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor =  Color.Transparent,
                ),
                value = "",
                onValueChange ={},
            )
        }
    }
}