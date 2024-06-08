package com.example.movieapp.navigation

enum class AppScreens {
    HomeScreen,
    DetailScreen,
    SearchScreen;

    companion object {
        fun fromRoute(route: String?): AppScreens
        = when(route?.substringBefore("/")){
            HomeScreen.name -> HomeScreen
            DetailScreen.name -> DetailScreen
            SearchScreen.name -> SearchScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route not found")
        }
    }
}