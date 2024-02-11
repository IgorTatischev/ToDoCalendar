package com.todo.todocalendar.di

import androidx.room.Room
import com.todo.todocalendar.data.repository.ToDoRepositoryImpl
import com.todo.todocalendar.data.source.ToDoDatabase
import com.todo.todocalendar.presentation.TodoViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

object MainModule {

    operator fun invoke() = module {
        single { Room.databaseBuilder(get(), ToDoDatabase::class.java, ToDoDatabase.DATABASE_NAME).build() }
        single { get<ToDoDatabase>().todoDao }
        single { ToDoRepositoryImpl(dao = get()) }

        viewModelOf(::TodoViewModel)
    }
}