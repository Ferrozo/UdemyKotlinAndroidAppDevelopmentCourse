package com.example.capstoneapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.capstoneapp.R
import com.example.capstoneapp.ui.theme.DarkBlueColor
import com.example.capstoneapp.ui.theme.TextGrayColor
import com.example.capstoneapp.ui.theme.WhiteColor

@Composable
fun SearchBox(
    value: String ,
    onValueChange: (String) -> Unit,
    enabled: Boolean,
    onClick: ()-> Unit? = {},
    onSearch: (String) -> Unit = {}
){
    Surface(
        color = WhiteColor,
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(horizontal = 20.dp),
        shadowElevation = 2.dp,
        onClick = {onClick()}
    ) {
        Row (
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            TextField(
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true,
                value = value,
                onValueChange = onValueChange,
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    color = DarkBlueColor
                ),
                placeholder = {
                    Text(
                        text = "Search your book",
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = TextGrayColor
                            ),
                    )
                },
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                ),

                suffix = {
                    Row(
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Divider(
                            Modifier
                                .height(25.dp)
                                .width(1.5.dp), color = TextGrayColor.copy(alpha = 0.5f))
                        Spacer(modifier = Modifier.width(15.dp))
                        IconButton(onClick = {onSearch(value)
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.search),
                                contentDescription = null,
                                tint = DarkBlueColor,
                                modifier = Modifier.size(25.dp)
                            )
                        }
                    }
                }
            )

        }
    }
}