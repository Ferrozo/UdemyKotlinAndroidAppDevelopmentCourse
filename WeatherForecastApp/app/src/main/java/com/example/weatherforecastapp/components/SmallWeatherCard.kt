package com.example.weatherforecastapp.components
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherforecastapp.ui.theme.WhiteColor


@Composable
fun SmallWeatherCard(
    title: String,
    degrees: String,
    icon: Painter,
    description: String
){
  Surface(
      modifier = Modifier
          .height(240.dp)
          .width(170.dp),
      color = Color.Gray.copy(alpha = 0.3f),
      shape = CircleShape.copy(all = CornerSize(10.dp))
  ) {
      Column(
          modifier = Modifier
              .fillMaxSize()
              .padding(15.dp)
          ,
      ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ){
            Icon(
                painter = icon,
                contentDescription= null,
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = title, style = TextStyle(color = Color.White.copy(alpha = 0.8f)))
        }
          Spacer(modifier = Modifier.height(15.dp))
          Text(
              text = degrees,
              style = TextStyle(
                  color = WhiteColor,
                  fontSize = 45.sp,
                  fontWeight = FontWeight.Bold
              )
          )
          Column(
              verticalArrangement = Arrangement.Bottom,
              modifier = Modifier.fillMaxSize()
          ) {
              Text(
                  text = description,
                  style = TextStyle(fontSize = 15.sp, color = Color.White.copy(alpha = 0.8f))
              )
          }
      }
  }
}