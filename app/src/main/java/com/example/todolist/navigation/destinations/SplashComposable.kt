package com.example.todolist.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.todolist.ui.screens.splash.SplashScreen
import com.example.todolist.util.Constants.SPLASH_SCREEN

fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit,
) {
    composable( route = SPLASH_SCREEN, )
     {
        SplashScreen(navigateToListScreen = navigateToListScreen)
    }
}