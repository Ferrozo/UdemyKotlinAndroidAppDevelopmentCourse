package com.example.weatherforecastapp.util

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import androidx.core.app.ActivityCompat
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
    val sdf = SimpleDateFormat("HH:mm:aa")
    val date = java.util.Date(timestamp * 1000L)
    return sdf.format(date)
}

data class LocationResult(val latitude: Double, val longitude: Double)

@SuppressLint("MissingPermission")
suspend fun getCurrentLocation(context: Context): LocationResult? {
    val fusedLocationProviderClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    // Check if location permissions are granted
    if (ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        // Handle permission request in your activity/fragment before calling this function
        return null
    }

    return suspendCancellableCoroutine { continuation ->
        val locationTask: Task<Location> =
            fusedLocationProviderClient.lastLocation

        locationTask.addOnSuccessListener { location ->
            if (location != null) {
                continuation.resume(
                    LocationResult(
                        latitude = location.latitude,
                        longitude = location.longitude
                    )
                )
            } else {
                continuation.resumeWithException(Exception("Location not found"))
            }
        }

        locationTask.addOnFailureListener { exception ->
            continuation.resumeWithException(exception)
        }

        continuation.invokeOnCancellation {
            locationTask.isCanceled()
        }
    }
}