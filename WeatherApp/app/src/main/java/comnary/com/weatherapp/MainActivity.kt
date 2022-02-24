package comnary.com.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import comnary.com.weatherapp.ui.theme.WeatherAppTheme
import comnary.com.weatherapp.ui.util.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                 Box(modifier = Modifier.background(
                     brush = Brush.linearGradient(
                         listOf(
                         MaterialTheme.colors.primary,
                         MaterialTheme.colors.primaryVariant)
                     )
                   )
                 )
                 {
                    Navigation()
                 }
                }
            }
        }
    }
}