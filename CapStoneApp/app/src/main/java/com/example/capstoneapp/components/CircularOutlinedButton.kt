package com.example.capstoneapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.example.capstoneapp.ui.theme.DarkBlueColor
import com.example.capstoneapp.ui.theme.TextGrayColor

@Composable
fun CircularOutlinedButton(
    icon: Painter,
    onClick: () -> Unit,
){
    IconButton(
        modifier = Modifier
            .padding(0.dp)
            .border(
                border = BorderStroke(width = 1.5.dp, color = TextGrayColor),
                shape = CircleShape
            )
            .size(50.dp),
        onClick = {onClick()},
    ) {
        Icon(
            icon,
            contentDescription = "",
            tint = DarkBlueColor,
            modifier = Modifier.size(25.dp)
        )
    }
}