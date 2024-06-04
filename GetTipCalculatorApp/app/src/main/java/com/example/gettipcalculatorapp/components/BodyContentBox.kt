package com.example.gettipcalculatorapp.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gettipcalculatorapp.ui.theme.GetTipCalculatorAppTheme
import com.example.gettipcalculatorapp.ui.theme.GrayColor80
import com.example.gettipcalculatorapp.ui.theme.GreenColor
import com.example.gettipcalculatorapp.ui.theme.WhiteColor10


@Composable
fun BodyContentBox(
    valueState: MutableState<String>,
    onValueChanged:(String) -> Unit = {}
){
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = GrayColor80,
        shape = CircleShape.copy(
            all = CornerSize(5.dp)
        )
    ){
        Column(
            modifier = Modifier
                .padding(vertical = 30.dp, horizontal = 15.dp),
            horizontalAlignment = Alignment.Start
        )
        {
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth() ,
            ){
                Text(
                    text = "Enter bill total",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = GreenColor,
                        fontWeight = FontWeight.Bold
                    )
                )
                Box(modifier = Modifier.width(30.dp))
                TextField(
                    modifier =
                    Modifier
                        .height(50.dp)
                        .border(
                            width = 1.5.dp,
                            color = GreenColor,
                            shape = CircleShape,
                        ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType =  KeyboardType.Number,
                        imeAction = ImeAction.Done,
                    ),
                    prefix = {
                        Text(
                            text="$ ",
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        )
                    },
                    value = valueState.value,
                    textStyle = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    ),

                    onValueChange = onValueChanged,
                    shape = CircleShape,
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = WhiteColor10,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,

                        ),

                )

            }
            Box(modifier = Modifier.height(20.dp))
            Text(
                text = "Tip",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = GreenColor,
                    fontWeight = FontWeight.Bold
                )
            )
            Box(modifier = Modifier.height(5.dp))
            Slider(
                modifier = Modifier.fillMaxWidth(),
                        colors = SliderDefaults.colors(
                            activeTickColor = GreenColor,
                            activeTrackColor = GreenColor
                        ),
                value = 2f, onValueChange ={} )
            Box(modifier = Modifier.height(15.dp))
            Divider( modifier = Modifier,
                color = Color.Gray.copy(0.1f,)
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    GetTipCalculatorAppTheme {
        MyApp()
    }
}
