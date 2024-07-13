package com.example.jettriviaapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jettriviaapp.util.AppColors

@Composable
fun MainButton(
    title: String,
    onClick: () -> Unit,
    color: Color
){
    Button(
        modifier = Modifier.height(60.dp).fillMaxWidth(),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = title,
            style = TextStyle(
                color = AppColors.whiteColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            )
    }
}