package com.example.todolist.ui.screens.task

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.todolist.data.models.Priority
import com.example.todolist.data.models.ToDoTask
import com.example.todolist.ui.viewmodels.SharedViewModel
import com.example.todolist.util.Action

@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {
    val title: String by sharedViewModel.title
    val description: String by sharedViewModel.description
    val priority: Priority by sharedViewModel.priority

    Scaffold(
        content = { paddingValues -> 
            TaskContent(
                modifier = Modifier.padding(paddingValues),
                title = title,
                onTitleChange = {sharedViewModel.title.value = it},
                description = description,
                onDescriptionChange = {sharedViewModel.description.value = it},
                priority = priority,
                onPriorityChange = {sharedViewModel.priority.value = it}
            ) },
        topBar = { TaskAppBar(
            navigateToListScreen = navigateToListScreen,
            selectedTask = selectedTask
        ) },
    )
}
