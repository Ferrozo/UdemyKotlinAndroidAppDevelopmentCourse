package com.example.gettipcalculatorapp.util


fun calculateTipAmount(totalBill: Float, tipPercentage: Int): Float {
    return if (totalBill > 1 && totalBill.toString().isNotEmpty()) (totalBill * tipPercentage) / 100 else 0.0f
}

fun calculateTotalPerPerson(
    totalBill: Float,
    splitBy: Int,
    tipPercentage: Int,
): Float{
    val bill = calculateTipAmount(totalBill = totalBill,tipPercentage = tipPercentage) + totalBill
    return (bill / splitBy)
}