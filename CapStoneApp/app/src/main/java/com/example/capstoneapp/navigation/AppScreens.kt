package com.example.capstoneapp.navigation

enum class AppScreens {
    HomeScreen,
    DetailScreen,
    LoginScreen,
    SplashScreen,
    SearchScreen,
    UpdateScreen,
    ReadingScreen;

    companion object {
      fun  fromRoute(route: String ): AppScreens
        = when (route.substringBefore("/")){
            AppScreens.SplashScreen.name -> SplashScreen
            AppScreens.HomeScreen.name -> HomeScreen
            AppScreens.DetailScreen.name -> DetailScreen
            AppScreens.LoginScreen.name -> LoginScreen
            AppScreens.SearchScreen.name -> SearchScreen
            AppScreens.UpdateScreen.name -> UpdateScreen
            AppScreens.ReadingScreen.name -> ReadingScreen
          else ->
          throw IllegalArgumentException("Route not found")

        }
    }

}