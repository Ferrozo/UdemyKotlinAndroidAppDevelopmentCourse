package com.example.gettipcalculatorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gettipcalculatorapp.ui.theme.GetTipCalculatorAppTheme
import com.example.gettipcalculatorapp.ui.theme.GrayColor80
import com.example.gettipcalculatorapp.ui.theme.GreenColor
import com.example.gettipcalculatorapp.ui.theme.WhiteColor10

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GetTipCalculatorAppTheme {
              MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = WhiteColor10,
    ) {
        Column (
            modifier = Modifier.padding(
                horizontal = 15.dp,
                vertical = 30.dp,
            )
        ) {
            HeaderBox()
            Box(modifier = Modifier.height(40.dp))
            MainContent()
        }
    }
}

@Composable
fun HeaderBox(){
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
                text = "$ 40.00",
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
                        text = "$ 40.00",
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = GreenColor,
                            fontWeight = FontWeight.Bold
                        ))
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
                        text = "$ 40.00",
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = GreenColor,
                            fontWeight = FontWeight.Bold
                        ))
                }
            }
        }
    }
}
@Composable
fun MainContent(){
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
                .padding(vertical = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        )
        {
          Row (
              horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
              modifier = Modifier
                  .fillMaxWidth()
                  .padding(horizontal = 20.dp),
          ){
              Text(
                  text = "Enter bill total",
                  style = TextStyle(
                      fontSize = 14.sp,
                      color = GreenColor,
                      fontWeight = FontWeight.Bold
                  )
              )
              Box(modifier = Modifier.width(10.dp))
              TextField(
                 prefix = {
                          Text(
                              text="$ ",
                              style = TextStyle(
                                  fontSize = 15.sp,
                                  fontWeight = FontWeight.Bold,
                              )
                          )
                 },
                  value = "200.23",
                  textStyle = TextStyle(
                      fontSize = 16.sp,
                      fontWeight = FontWeight.Bold,
                  ),
                  modifier =
                  Modifier
                      .height(55.dp)
                      .border(
                          width = 1.5.dp,
                          color = GreenColor,
                          shape = CircleShape,
                      ),
                  onValueChange = {},
                  shape = CircleShape,
                  colors = TextFieldDefaults.colors(
                      unfocusedContainerColor = WhiteColor10,
                      unfocusedIndicatorColor = Color.Transparent,
                      focusedIndicatorColor = Color.Transparent,

                      ),
                  )

          }
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
                        text = "$ 40.00",
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = GreenColor,
                            fontWeight = FontWeight.Bold
                        ))
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
                        text = "$ 40.00",
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = GreenColor,
                            fontWeight = FontWeight.Bold
                        ))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GetTipCalculatorAppTheme {
        MyApp()
    }
}