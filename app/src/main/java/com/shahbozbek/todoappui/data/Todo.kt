package com.shahbozbek.todoappui.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_app")
data class Todo(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val title: String,
    val description: String,
    val date: String,
    val hour: String,
    val checked: Boolean
)