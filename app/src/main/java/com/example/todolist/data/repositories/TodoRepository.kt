package com.example.todolist.data.repositories

import com.example.todolist.data.TodoDao
import com.example.todolist.data.models.ToDoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class TodoRepository @Inject constructor(private val todoDao: TodoDao) {
    val getAllTasks: Flow<List<ToDoTask>> = todoDao.getAllTasks()
    val sortByLowPriority: Flow<List<ToDoTask>> = todoDao.sortByLowPriority()
    val sortByHighPriority: Flow<List<ToDoTask>> = todoDao.sortByHighPriority()

    fun getSelectedTask(taskId: Int): Flow<ToDoTask> = todoDao.getSelectedTask(taskId)
    suspend fun addTask(toDoTask: ToDoTask) = todoDao.addTask(toDoTask)
    suspend fun updateTask(toDoTask: ToDoTask) = todoDao.updateTask(toDoTask)
    suspend fun deleteTask(toDoTask: ToDoTask) = todoDao.deleteTask(toDoTask)
    suspend fun deleteAllTasks() = todoDao.deleteAllTasks()
    fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>> = todoDao.searchDatabase(searchQuery)
}