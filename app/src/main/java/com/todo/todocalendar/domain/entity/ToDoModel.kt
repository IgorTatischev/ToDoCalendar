package com.todo.todocalendar.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDoItem(
    val task: String = "",
    val done: Boolean = false,
    val date: String = "",

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)