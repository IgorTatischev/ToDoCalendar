package com.todo.todocalendar.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun TaskItem(task: String, done: Boolean, delete: () -> Unit, doneChange: (Boolean) -> Unit) {
    Card {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

            Checkbox(checked = done, onCheckedChange = doneChange)

            TextField(value = task, onValueChange = {}, readOnly = true)

            IconButton(onClick = delete) {
                Icon(imageVector = Icons.Default.Dangerous, contentDescription = null)
            }
        }
    }
}