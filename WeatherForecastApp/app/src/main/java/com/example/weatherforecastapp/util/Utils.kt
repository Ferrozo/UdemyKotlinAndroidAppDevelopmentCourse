package com.example.weatherforecastapp.util

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.suspendCancellableCoroutine
import java.text.SimpleDateFormat
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

@SuppressLint("SimpleDateFormat")
fun formatDate(timestamp: Int ): String {
    val sdf = SimpleDateFormat("EEE/MM/d")
    val date = java.util.Date(timestamp * 1000L)
    return sdf.format(date)
}

@SuppressLint("SimpleDateFormat")
fun formatTime(timestamp: Int ): String {
    val sdf = SimpleDateFormat("HH:mm")
    val date = java.util.Date(timestamp * 1000L)
    return sdf.format(date)
}

data class LocationResult(val latitude: Double, val longitude: Double)
@SuppressLint("MissingPermission")
suspend fun getCurrentLocation(context: Context): LocationResult {
    val fusedLocationProviderClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    return suspendCancellableCoroutine { continuation ->
        val task: Task<Location> = fusedLocationProviderClient.lastLocation
        task.addOnSuccessListener { location ->
            if (location != null) {
                continuation.resume(LocationResult(location.latitude, location.longitude))
            } else {
                continuation.resumeWithException(Exception("Location not found"))
            }
        }
        task.addOnFailureListener { exception ->
            continuation.resumeWithException(exception)
        }
    }
}

fun fahrenheitToCelsius(fahrenheit: Double): Double {
    return (fahrenheit - 32) * 5.0 / 9.0
}