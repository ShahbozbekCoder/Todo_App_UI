package com.shahbozbek.todoappui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyNavigation(
    viewModel: TodoViewModel
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            BottomAppBarWithFAB(navController = navController, todoViewModel = viewModel)
        }
        composable("add") {
            AddScreen(navController = navController, todoViewModel = viewModel)
        }
        composable("edit") {
            EditScreen(navController = navController, todoViewModel = viewModel)
        }
    }

}