package comnary.com.todoapp.ui.main.componets

import android.graphics.Paint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import comnary.com.todoapp.ui.main.AddTodoDialog
import comnary.com.todoapp.ui.main.MainViewModel

@Composable
fun MainScree(viewModel: MainViewModel = hiltViewModel())
{
    val notes = viewModel.todoItemState.value

    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {
            viewModel.showDialog()
        })
        {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add a new todo")
        }
    }) {
        Box(modifier = Modifier.fillMaxSize())
        {
            LazyColumn(Modifier.fillMaxSize())
            {
                item {
                    Text(text = "My TODOs:", style = MaterialTheme.typography.h6, modifier = Modifier.padding(8.dp))
                }

                if(notes.isNotEmpty())
                {
                    items(notes){ todo->
                        TodoItemComposable(
                            todoItem = todo,
                            onTodoDone = {viewModel.insert_todo_itme(todo.copy(isDone = it))},
                            onDelete = {viewModel.delete_todo_item(todo)})
                    }
                }
                else
                {
                    item {
                        Text(text = "No TODOs for you! click on the + sign to add new TODOs",Modifier.padding(4.dp))
                    }
                }
            }
            
            if(viewModel.isDialogShow.value)
            {
                AddTodoDialog(onDismiss = { viewModel.hideDialog()}, onSave = {viewModel.insert_todo_itme(it)} )
            }
        }
    }
}