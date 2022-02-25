package comnary.com.todoapp.ui.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import comnary.com.todoapp.data.local.TodoItem
import comnary.com.todoapp.repo.TodoRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repo: TodoRepo):ViewModel() {
    private val _todoItemState = mutableStateOf(emptyList<TodoItem>())
    val todoItemState: State<List<TodoItem>> = _todoItemState

    private val _isDialogShowing = mutableStateOf(false)
    val isDialogShow:State<Boolean> = _isDialogShowing

    init {
        get_todo_itme()
    }

    fun showDialog()
    {
        _isDialogShowing.value = true
    }

    fun hideDialog()
    {
        _isDialogShowing.value = false
    }

    fun insert_todo_itme(todoItem: TodoItem)
    {
        viewModelScope.launch {
            repo.insert_todo_item(todoItem)
        }
    }

    fun delete_todo_item(todoItem: TodoItem)
    {
        viewModelScope.launch {
            repo.delete_todo_item(todoItem)
        }
    }

    private fun get_todo_itme()
    {
        repo.get_todo_itme().onEach { notes->
            _todoItemState.value = notes
        }.launchIn(viewModelScope)
    }
}