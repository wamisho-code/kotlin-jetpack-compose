package com.example.myjetcompose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myjetcompose.view.FirstScreen
import com.example.myjetcompose.view.SecondScreen

class NavigationCode {
    @Composable
    fun NavigationCodeMethod() {
        val navController = rememberNavController()
        NavHost(navController, startDestination = "first_screen") {
            composable("first_screen") {
                FirstScreen(navController)
            }
            composable("second_screen") {
                SecondScreen(navController)
            }
        }
    }
}