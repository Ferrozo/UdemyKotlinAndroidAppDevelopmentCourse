package com.example.jettriviaapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jettriviaapp.util.AppColors

//@Preview(showBackground = true)
@Composable
fun QuizCard(
    answer: String,
    onSelected: Boolean,
    isCorrect: Boolean,
    onClick: () -> Unit
){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable {
                       onClick()
            }
        ,
        color = if(onSelected && isCorrect) {
            AppColors.greenColor
            } else if (onSelected && !isCorrect ) {
                Color.Red.copy(alpha = 0.5f)
            } else {
                AppColors.orangeColor
            },
        shape = RoundedCornerShape(10.dp)
    ){
        Row(
            modifier =  Modifier
                .padding(horizontal = 15.dp, vertical = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = answer,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = AppColors.whiteColor,
                    fontWeight = FontWeight.Bold
                )
            )
            if(onSelected && isCorrect)
                Icon(
                    Icons.Default.Check,
                    contentDescription = "Quiz Card Icon",
                    tint = AppColors.whiteColor,
                    modifier = Modifier.size(30.dp)
                )
            if(onSelected && !isCorrect)
                Icon(
                    Icons.Default.Close,
                    contentDescription = "Quiz Card Icon",
                    tint = AppColors.whiteColor,
                    modifier = Modifier.size(30.dp)
                )
        }
    }
}