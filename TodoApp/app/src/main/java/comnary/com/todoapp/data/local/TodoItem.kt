package comnary.com.todoapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoItem(
    val content:String,
    val isDone:Boolean = false,
    @PrimaryKey val id: Int?= null
)
