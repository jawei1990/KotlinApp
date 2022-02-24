package comnary.com.weatherapp.repo


import comnary.com.weatherapp.util.Resource
import comnary.com.weatherapp.data.CityWeather
import comnary.com.weatherapp.data.WeatherApi
import java.lang.Exception
import javax.inject.Inject

class WeatherRepo @Inject constructor(private val weatherApi: WeatherApi) {
    suspend fun getWeatherForCity(city:String): Resource<CityWeather>
    {
        return try {
            val response = weatherApi.getWeatherForCity(city)

            if(response.isSuccessful)
            {
                Resource.success(response.body())
            }
            else {
                Resource.error(response.message(), null)
            }
        }catch (e:Exception)
        {
            Resource.error("Couldn't connect to server.Check your internet connection.", null)
        }

    }

}