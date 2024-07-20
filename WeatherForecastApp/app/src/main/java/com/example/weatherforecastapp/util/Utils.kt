package com.example.weatherforecastapp.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat


@SuppressLint("SimpleDateFormat")
fun formatDate(timestamp: Int ): String {
    val sdf = SimpleDateFormat("EEE/MM/d")
    val date = java.util.Date(timestamp * 1000L)
    return sdf.format(date)
}

@SuppressLint("SimpleDateFormat")
fun formatTime(timestamp: Int ): String {
    val sdf = SimpleDateFormat("HH:mm:aa")
    val date = java.util.Date(timestamp * 1000L)
    return sdf.format(date)
}