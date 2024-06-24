package com.example.todolist.navigation


import androidx.navigation.NavHostController
import com.example.todolist.util.Action
import com.example.todolist.util.Constants.LIST_SCREEN

class Screens(navController: NavHostController) {
    val task: (Action) -> Unit = { action ->
        navController.navigate(route = "list/${action.name}"){
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }
    val list: (Int) -> Unit = { taskId ->
        navController.navigate(route = "task/$taskId")
    }
}