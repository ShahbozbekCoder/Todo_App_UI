package com.shahbozbek.todoappui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun EditScreen(navController: NavHostController, todoViewModel: TodoViewModel) {
    todoViewModel.getAll()
}
