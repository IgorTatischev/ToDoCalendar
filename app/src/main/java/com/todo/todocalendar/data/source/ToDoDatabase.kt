package com.todo.todocalendar.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.todo.todocalendar.domain.entity.ToDoItem

@Database(
    entities = [ToDoItem::class],
    version = 3
)
abstract class ToDoDatabase: RoomDatabase() {

    abstract val todoDao : ToDoDao

    companion object{
        const val DATABASE_NAME = "todo_db"
    }
}