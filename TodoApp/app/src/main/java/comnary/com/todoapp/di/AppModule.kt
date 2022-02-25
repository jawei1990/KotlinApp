package comnary.com.todoapp.di

import android.app.Application
import androidx.room.Room
import comnary.com.todoapp.data.local.TodoDatabase
import comnary.com.todoapp.repo.TodoRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provide_todo_database(application: Application):TodoDatabase
    {
        return Room.databaseBuilder(
            application,
            TodoDatabase::class.java,
            TodoDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepo(todoDatabase: TodoDatabase):TodoRepo = TodoRepo(todoDatabase.todoDao)
}