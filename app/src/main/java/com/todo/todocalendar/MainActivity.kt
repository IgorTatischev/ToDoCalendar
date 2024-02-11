package com.todo.todocalendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.todo.todocalendar.presentation.TodoScreen
import com.todo.todocalendar.ui.theme.ToDoCalendarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoCalendarTheme {
                TodoScreen()
            }
        }
    }
}

