package comnary.com.weatherapp.di

import comnary.com.weatherapp.data.WeatherApi
import comnary.com.weatherapp.repo.WeatherRepo
import comnary.com.weatherapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object appModule {

    @Singleton
    @Provides
    fun provide_weather_api():WeatherApi
    {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)

    }

    @Singleton
    @Provides
    fun providerWeatherRepo(weatherApi: WeatherApi):WeatherRepo
    {
        return WeatherRepo(weatherApi)
    }
}