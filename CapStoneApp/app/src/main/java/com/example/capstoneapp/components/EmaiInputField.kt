package com.example.capstoneapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capstoneapp.ui.theme.DarkBlueColor
import com.example.capstoneapp.ui.theme.TextGrayColor
import com.example.capstoneapp.ui.theme.WhiteColor

@Composable
fun EmailInputField(
    email: MutableState<String>
){
    TextField(
        modifier = Modifier
            .shadow(1.dp)
            .fillMaxWidth(),
        textStyle = TextStyle(
            fontSize = 16.sp,
            color = DarkBlueColor
        ),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = WhiteColor,
            focusedContainerColor = WhiteColor,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        shape = RectangleShape,
        value = email.value,
        onValueChange = {email.value = it },
        placeholder = {
            Text(
                text = "Email",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = TextGrayColor
                ),
            )
        }
    )
}