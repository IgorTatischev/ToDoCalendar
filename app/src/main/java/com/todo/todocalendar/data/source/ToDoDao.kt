package com.todo.todocalendar.data.source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.todo.todocalendar.domain.entity.ToDoItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    @Query("SELECT * FROM ToDoItem WHERE date like :date")
    fun getTasks(date: String): Flow<List<ToDoItem>>

    @Insert
    suspend fun insertTask(item: ToDoItem)

    @Delete
    suspend fun deleteTask(item: ToDoItem)

    @Update
    suspend fun updateTask(item: ToDoItem)
}