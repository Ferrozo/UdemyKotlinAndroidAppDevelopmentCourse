package com.example.jettriviaapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jettriviaapp.util.AppColors

@Composable
fun QuizHeader(
    questionCount: Int,
    questionOff: Int
){
    val progress = if (questionOff == 0) 0f else questionCount.toFloat() / questionOff.toFloat()
    Column(modifier = Modifier.fillMaxWidth()) {
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth().height(5.dp),
            progress = progress,
            color = AppColors.greenColor,
            trackColor = AppColors.pinkColor
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = buildAnnotatedString {
                withStyle(style = ParagraphStyle(textIndent = TextIndent.None)){
                    withStyle(
                        style = SpanStyle(
                            color = AppColors.greenColor,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    )
                    {
                        append("$questionCount")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = AppColors.orangeColor,
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp,
                        )
                    ){
                        append("/$questionOff")
                    }
                }
            }
        )
    }
}