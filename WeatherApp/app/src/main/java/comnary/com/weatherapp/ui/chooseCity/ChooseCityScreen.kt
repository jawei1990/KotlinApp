package comnary.com.weatherapp.di

import android.text.Layout
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import comnary.com.weatherapp.ui.util.Screen
import org.intellij.lang.annotations.JdkConstants

@Composable
fun ChooseCityScreen(navController: NavController)
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ){
        val (cityName,setCityName) = remember {
            mutableStateOf("")
        }
        Text("My Weather App", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = cityName, 
            onValueChange ={setCityName(it)},
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp)),
            colors = TextFieldDefaults.textFieldColors(MaterialTheme.colors.background),
            label = { Text(text = "city")},
            textStyle = TextStyle(fontSize = 16.sp)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
                         if(cityName.isNotBlank())
                             navController.navigate(Screen.WeatherScreen.route + cityName)
        },colors = ButtonDefaults.buttonColors(backgroundColor =  MaterialTheme.colors.secondary),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()) {
            Text("Choose")
        }
    }
}