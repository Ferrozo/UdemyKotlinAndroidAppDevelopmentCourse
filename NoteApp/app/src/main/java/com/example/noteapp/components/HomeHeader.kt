package com.example.noteapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapp.R
import com.example.noteapp.ui.theme.DarkColor
import com.example.noteapp.ui.theme.GrayColor
import com.example.noteapp.ui.theme.WhiteColor


@Composable
fun HomeHeader(
    onValueChange: (String) -> Unit,
    value: String,
){
    Column {
        Text(
            text = "My Notes",
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = DarkColor
            )
        )
        Spacer(modifier = Modifier.height(15.dp))
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp),
            value = value,
            textStyle = TextStyle(
                color = WhiteColor,
            ),
            prefix = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(
                        painter = painterResource(R.drawable.search),
                        contentDescription = null,
                        tint = WhiteColor,
                        modifier = Modifier.size(25.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                }
            },
            placeholder = {
                Text(text ="Search your notes")
            },
            onValueChange = onValueChange,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedContainerColor = GrayColor,
                focusedContainerColor = GrayColor,
                focusedTextColor = WhiteColor,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = CircleShape
        )
        Spacer(modifier = Modifier.height(15.dp))

    }
}

@Preview
@Composable
fun HomeHeaderPreview(){
    HomeHeader(
        onValueChange= {  },
    value= "",
    )
}