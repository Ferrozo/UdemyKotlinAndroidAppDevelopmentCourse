package com.example.bizcardapp.widgets

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bizcardapp.R
import com.example.bizcardapp.ui.theme.BizCardAppTheme
import com.example.bizcardapp.ui.theme.WhiteGrayColor

@Composable
fun PortfolioCard(
    title: String,
    description: String,
    image: Painter,
    ){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(horizontal = 5.dp)
        ,
        color = WhiteGrayColor.copy(alpha = 0.1f),
        shape = RoundedCornerShape(
          15.dp
        )
    ){
        Row(){
            Image(
                painter = image,
                contentDescription = title,
                modifier = Modifier
                    .width(100.dp)
                    .clip(
                    RoundedCornerShape(
                        topStart = 15.dp,
                        bottomStart = 15.dp
                    ),
                ),
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier.width(20.dp))
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(vertical = 10.dp)
                ,
                verticalArrangement = Arrangement.SpaceBetween
            )
            {
                Text(
                    text = title,
                    style =
                    TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = WhiteGrayColor,
                        fontSize = 20.sp,
                    )
                )
                Box(modifier = Modifier.height(5.dp))
                Text(
                    text = description,
                    style = TextStyle(
                        color = WhiteGrayColor.copy(alpha = 0.7f)
                    )
                )
            }
        }
    }
}