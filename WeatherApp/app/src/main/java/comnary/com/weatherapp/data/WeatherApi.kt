package comnary.com.weatherapp.data

import comnary.com.weatherapp.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("weather")
    suspend fun getWeatherForCity(
        @Query("q") city_name:String,
        @Query("appid") api_id:String = Constants.API_KEY,
        @Query("units") units:String = "metric"
    ): Response<CityWeather>
}