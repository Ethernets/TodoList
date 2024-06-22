package com.example.todolist.ui.screens.task

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
    val title: String = sharedViewModel.title
    val description: String by sharedViewModel.description
    val priority: Priority by sharedViewModel.priority
    val context = LocalContext.current

    Scaffold(
        content = { paddingValues -> 
            TaskContent(
                modifier = Modifier.padding(paddingValues),
                title = title,
                onTitleChange = {sharedViewModel.updateTitle(it)},
                description = description,
                onDescriptionChange = {sharedViewModel.description.value = it},
                priority = priority,
                onPriorityChange = {sharedViewModel.priority.value = it}
            ) },
        topBar = { TaskAppBar(
            navigateToListScreen = { action ->
                if(action == Action.NO_ACTION){
                    navigateToListScreen(action)
                } else {
                    if (sharedViewModel.validateFields()){
                        navigateToListScreen(action)
                    } else {
                        displayToastMessage(context = context)
                    }
                }
            },
            selectedTask = selectedTask
        ) },
    )
}

fun displayToastMessage(context: Context) {
    Toast.makeText(context, "Fields Empty", Toast.LENGTH_SHORT).show()
}
