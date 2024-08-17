package com.example.capstoneapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capstoneapp.R
import com.example.capstoneapp.ui.theme.DarkBlueColor
import com.example.capstoneapp.ui.theme.TextGrayColor
import com.example.capstoneapp.ui.theme.WhiteColor

@Composable
fun PasswordInputField(
    password: MutableState<String>
){
    val isVisible = rememberSaveable {
            mutableStateOf(false)
    }
    val visualTransformation  = if(isVisible.value) VisualTransformation.None else  PasswordVisualTransformation()
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
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        shape = RectangleShape,
        suffix = {
                 IconButton(onClick = { isVisible.value = ! isVisible.value}) {
                     Icon(
                         painter = painterResource(id = if (isVisible.value)
                         R.drawable.eye1 else R.drawable.eye2),
                         contentDescription = null,
                         modifier = Modifier.size(25.dp),
                         tint = DarkBlueColor
                     )
                 }
        },
        value = password.value,
        onValueChange = {password.value = it},
        placeholder = {
            Text(
                text = "Password",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = TextGrayColor
                ),
            )
        }
    )
}