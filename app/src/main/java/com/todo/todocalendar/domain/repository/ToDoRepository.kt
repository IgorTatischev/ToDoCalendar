package com.todo.todocalendar.domain.repository

import com.todo.todocalendar.domain.entity.ToDoItem
import kotlinx.coroutines.flow.Flow

interface ToDoRepository {

    fun getTasks(date: String): Flow<List<ToDoItem>>

    suspend fun insertTask(item: ToDoItem)

    suspend fun deleteTask(item: ToDoItem)

    suspend fun updateTask(item: ToDoItem)
}