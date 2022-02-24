package comnary.com.weatherapp.ui.weatherScreen

import android.view.View
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import comnary.com.weatherapp.data.CityWeather
import comnary.com.weatherapp.repo.WeatherRepo
import comnary.com.weatherapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherRepo: WeatherRepo):ViewModel()
{
    private val _cityWeather = mutableStateOf<Resource<CityWeather>>(Resource.loading(null))
    val cityWeather: State<Resource<CityWeather>> = _cityWeather
    fun getWeatherForCity(city:String)
    {
        viewModelScope.launch {
            _cityWeather.value = weatherRepo.getWeatherForCity(city)
        }
    }
}