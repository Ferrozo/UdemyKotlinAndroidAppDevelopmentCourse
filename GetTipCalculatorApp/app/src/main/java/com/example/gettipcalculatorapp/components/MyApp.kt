package com.example.gettipcalculatorapp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gettipcalculatorapp.ui.theme.WhiteColor10
import com.example.gettipcalculatorapp.util.calculateTipAmount
import com.example.gettipcalculatorapp.util.calculateTotalPerPerson


@Composable
fun MyApp() {
    val totalValueState = remember {
        mutableStateOf(value = "0")
    }
    val scrollable = rememberScrollState()
    val slideTipValue = remember {
        mutableFloatStateOf(value = 0f)
    }
    val slidePersonValue = remember {
        mutableFloatStateOf(value = 0f)
    }

    val tipAmountState = remember {
        mutableFloatStateOf(value = 0.0f)
    }
    val totalPerPersonState = remember {
        mutableFloatStateOf(value = 0.0f)
    }
    val percentage = (slideTipValue.floatValue * 100).toInt()
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = WhiteColor10,
    ) {
        Column (
            modifier = Modifier
                .padding(
                    horizontal = 15.dp,
                    vertical = 40.dp,
                )
                .verticalScroll(scrollable)
        ) {
            HeaderBox(
                totalBill =  totalValueState.value.toDouble(),
                totalTip = tipAmountState.floatValue.toDouble(),
                totalPerPerson = totalPerPersonState.floatValue.toDouble()
            )
            Box(modifier = Modifier.height(40.dp))
            BodyContentBox(
                onTextFieldValueChanged = {
                    totalValueState.value = it
                    totalPerPersonState.floatValue = calculateTotalPerPerson(
                        totalBill = totalValueState.value.toFloat(),
                        splitBy = slidePersonValue.floatValue.toInt(),
                        tipPercentage = percentage,
                    )
                },
                onSlideTipValueChanged = {
                    tipAmountState.floatValue = calculateTipAmount(totalBill = totalValueState.value.toFloat(), tipPercentage =  percentage)
                    slideTipValue.floatValue = it
                    totalPerPersonState.floatValue = calculateTotalPerPerson(
                        totalBill = totalValueState.value.toFloat(),
                        splitBy = slidePersonValue.floatValue.toInt(),
                        tipPercentage = percentage,
                    )
                },
                onSlidePersonValueChanged = {
                    slidePersonValue.floatValue = it
                    totalPerPersonState.floatValue =  calculateTotalPerPerson(
                        totalBill = totalValueState.value.toFloat(),
                        splitBy = slidePersonValue.floatValue.toInt(),
                        tipPercentage = percentage,
                    )
                },
                valueState = totalValueState,
                slideTipValue = slideTipValue,
                slidePersonValue =slidePersonValue,
                percentage = percentage
            )
        }
    }
}