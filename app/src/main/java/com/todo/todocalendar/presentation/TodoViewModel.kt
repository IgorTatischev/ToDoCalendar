package com.todo.todocalendar.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.todo.todocalendar.data.repository.ToDoRepositoryImpl
import com.todo.todocalendar.domain.entity.ToDoItem
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.time.LocalDate

class TodoViewModel(private val repository: ToDoRepositoryImpl) : ViewModel() {

    private val _state = MutableStateFlow(TodoScreenState())
    val state = _state.asStateFlow()

    private var getNotesJob : Job? = null

    fun getTasks(date: LocalDate){
        getNotesJob?.cancel()
        getNotesJob = repository.getTasks(date.toString()).onEach { tasks ->
            _state.value = state.value.copy(tasks = tasks, selectedDate = date)
        }.launchIn(viewModelScope)
    }

    fun insertTask(done: Boolean, task: String, date: String) {
        viewModelScope.launch {
            repository.insertTask(
                ToDoItem(
                    done = done,
                    task = task,
                    date = date,
                )
            )
        }
    }

    fun deleteTask(item: ToDoItem) {
        viewModelScope.launch {
            repository.deleteTask(item = item)
        }
    }

    fun updateTask(item: ToDoItem, done: Boolean) {
        viewModelScope.launch {
            repository.updateTask(item.copy(done = done))
        }
    }

}