package com.example.todolist.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todolist.data.models.ToDoTask

@Database(entities = [ToDoTask::class], version = 1, exportSchema = false)
abstract class TodoDatabase: RoomDatabase() {
    abstract fun todoDao(): TodoDao

}