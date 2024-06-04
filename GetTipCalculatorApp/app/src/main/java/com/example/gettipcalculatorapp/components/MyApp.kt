package com.example.gettipcalculatorapp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gettipcalculatorapp.ui.theme.GetTipCalculatorAppTheme
import com.example.gettipcalculatorapp.ui.theme.WhiteColor10


@Composable
fun MyApp() {
    val totalValueState = remember {
        mutableStateOf(value = "")
    }
    val validState = remember(totalValueState.value) {
        totalValueState.value.trim().isNotEmpty()
    }
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = WhiteColor10,
    ) {
        Column (
            modifier = Modifier.padding(
                horizontal = 15.dp,
                vertical = 40.dp,
            )
        ) {
            HeaderBox()
            Box(modifier = Modifier.height(40.dp))
            BodyContentBox(
                valueState = totalValueState
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun MyAppPreview() {
//    GetTipCalculatorAppTheme {
//        MyApp()
//    }
//}