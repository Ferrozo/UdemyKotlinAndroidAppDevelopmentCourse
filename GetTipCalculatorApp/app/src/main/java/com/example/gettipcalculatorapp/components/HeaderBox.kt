package com.example.gettipcalculatorapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gettipcalculatorapp.ui.theme.GrayColor80
import com.example.gettipcalculatorapp.ui.theme.GreenColor


@Composable
fun HeaderBox(
    totalBill: Double,
    totalTip: Double,
    totalPerPerson: Double,
){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        color = GrayColor80,
        shape = CircleShape.copy(all = CornerSize(5.dp))
    ){
        Column(
            modifier = Modifier
                .padding(vertical = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text(
                text = "Total per person",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            )
            Box(modifier = Modifier.height(10.dp))
            Text(
                text = "$ $totalPerPerson",
                style = TextStyle(
                    fontSize = 40.sp,
                    color = GreenColor,
                    fontWeight = FontWeight.Bold
                )
            )
            Box(modifier = Modifier.height(15.dp))
            Divider(
                modifier = Modifier,
                color = Color.Gray.copy(0.1f)
            )
            Box(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                ,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Column {
                    Text(
                        text = "Total Bill",
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    )
                    Box(modifier = Modifier.height(10.dp))
                    Text(
                        text = "$ $totalBill",
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = GreenColor,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                Column {
                    Text(
                        text = "Total Tip",
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    )
                    Box(modifier = Modifier.height(10.dp))
                    Text(
                        text = "$ $totalTip",
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = GreenColor,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }
    }
}