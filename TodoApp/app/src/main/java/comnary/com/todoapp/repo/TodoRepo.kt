package comnary.com.todoapp.repo

import comnary.com.todoapp.data.local.TodoDao
import comnary.com.todoapp.data.local.TodoItem

class TodoRepo(private val dao:TodoDao) {
    suspend fun insert_todo_item(todoItem: TodoItem) = dao.insert_todo_item(todoItem)
    suspend fun delete_todo_item(todoItem: TodoItem) = dao.delete_todo_item(todoItem)
    fun get_todo_itme() = dao.get_todo_item()
}