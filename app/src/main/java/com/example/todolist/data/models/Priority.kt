package com.example.todolist.data.models

import androidx.compose.ui.graphics.Color
import com.example.todolist.ui.theme.HighPriority
import com.example.todolist.ui.theme.LowPriority
import com.example.todolist.ui.theme.MediumPriority
import com.example.todolist.ui.theme.NonePriority


enum class Priority(val color: Color) {
    HIGH(HighPriority),
    MEDIUM(MediumPriority),
    LOW(LowPriority),
    NONE(NonePriority),
}