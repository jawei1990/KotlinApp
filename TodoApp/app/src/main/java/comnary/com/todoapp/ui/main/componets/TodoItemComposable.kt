package comnary.com.todoapp.ui.main.componets

import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.DeleteForever
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import comnary.com.todoapp.data.local.TodoItem

@Composable
fun TodoItemComposable(
    todoItem: TodoItem,
    onTodoDone: (Boolean)->Unit,
    onDelete:()->Unit
)
{
    Row(Modifier.fillMaxWidth()) {
        Checkbox(checked = todoItem.isDone, onCheckedChange = onTodoDone)
        Spacer(modifier =Modifier.width(8.dp))
        Text(todoItem.content)
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End)
        {
            IconButton(onClick = { onDelete() }) {
                Icon(imageVector = Icons.Outlined.DeleteForever, contentDescription = "Delete")
            }
        }
    }
}