package com.todo.todocalendar.presentation

import com.todo.todocalendar.domain.entity.ToDoItem
import java.time.LocalDate

data class TodoScreenState(
    val tasks: List<ToDoItem> = emptyList(),
    val selectedDate: LocalDate = LocalDate.now()
)