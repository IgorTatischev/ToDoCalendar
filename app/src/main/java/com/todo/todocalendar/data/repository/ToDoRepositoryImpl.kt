package com.todo.todocalendar.data.repository

import com.todo.todocalendar.data.source.ToDoDao
import com.todo.todocalendar.domain.entity.ToDoItem
import com.todo.todocalendar.domain.repository.ToDoRepository
import kotlinx.coroutines.flow.Flow

class ToDoRepositoryImpl(private val dao: ToDoDao): ToDoRepository {

    override fun getTasks(date: String): Flow<List<ToDoItem>> = dao.getTasks(date)

    override suspend fun insertTask(item: ToDoItem) = dao.insertTask(item)

    override suspend fun deleteTask(item: ToDoItem) = dao.deleteTask(item)

    override suspend fun updateTask(item: ToDoItem) = dao.updateTask(item)
}