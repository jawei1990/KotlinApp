package comnary.com.todoapp.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import comnary.com.todoapp.data.local.TodoItem


@Composable
fun AddTodoDialog(onDismiss:()->Unit,onSave:(TodoItem)->Unit)
{
    val (text,setText) = remember { mutableStateOf("") }

    Box(modifier = Modifier
        .fillMaxSize()
        .clickable { onDismiss() }
        .background(Color.Gray.copy(0.6f)),
        contentAlignment = Alignment.Center
        )
        {
            Box(modifier = Modifier.clip(RoundedCornerShape(8.dp))
                .clickable(enabled = false){}
                .background( MaterialTheme.colors.background))
            {
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(8.dp))
                {
                    Text(text = "Add a new TODO!")
                    TextField(
                        value = text,
                        onValueChange = setText,
                        colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.background),
                        label = {Text(text = "TODO")}
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = {
                        if(text.isNotBlank())
                        {
                            onSave(TodoItem(text))
                            onDismiss
                        }}
                    )
                    {
                        Text("Save")
                    }
                }
            }

        }
}