package com.todo.todocalendar.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DoneOutline
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.todo.todocalendar.R
import com.todo.todocalendar.presentation.TodoViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SheetContent(viewModel: TodoViewModel = koinViewModel()) {

    val state = viewModel.state.collectAsState().value

    LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(10.dp)) {

        item {
            Text(text = state.selectedDate.toString(), style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(10.dp))
            Card {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val (task, setTask) = remember { mutableStateOf("") }
                    val (done, setDone) = remember { mutableStateOf(false) }

                    Checkbox(checked = done, onCheckedChange = setDone)

                    TextField(
                        value = task,
                        onValueChange = setTask,
                        placeholder = { Text(text = stringResource(id = R.string.hint)) }
                    )

                    IconButton(onClick = {
                        viewModel.insertTask(done, task, state.selectedDate.toString())
                    }) {
                        Icon(imageVector = Icons.Default.DoneOutline, contentDescription = null)
                    }
                }
            }
            Divider(modifier = Modifier.padding(15.dp))
        }

        items(items = state.tasks) { task ->

            var done by remember { mutableStateOf(task.done) }

            TaskItem(
                task = task.task,
                done = done,
                delete = { viewModel.deleteTask(task) }
            ) {
                done = !done
                viewModel.updateTask(task, done)
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}