package com.example.noteapp.navigation

enum class AppScreens {

    HomeScreen,
    DetailScreen,
    AddNoteScreen,
    UpdateNoteScreen;

    companion object {
        fun fromRoute(route: String?): AppScreens
                = when(route?.substringBefore("/")){
            HomeScreen.name -> HomeScreen
            DetailScreen.name -> DetailScreen
            AddNoteScreen.name -> AddNoteScreen
            UpdateNoteScreen.name -> UpdateNoteScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route not found")
        }
    }
}