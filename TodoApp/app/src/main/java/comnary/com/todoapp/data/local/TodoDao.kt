package comnary.com.todoapp.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert_todo_item(todoItem: TodoItem)

    @Delete
    suspend fun delete_todo_item(todoItem: TodoItem)

    @Query("SELECT * FROM todoitem")
    fun get_todo_item(): Flow<List<TodoItem>>
}