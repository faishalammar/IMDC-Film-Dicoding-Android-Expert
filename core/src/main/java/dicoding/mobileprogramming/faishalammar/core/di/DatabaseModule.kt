package dicoding.mobileprogramming.faishalammar.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dicoding.mobileprogramming.faishalammar.core.data.source.local.room.MoviesSeriesDatabase
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): MoviesSeriesDatabase = Room.databaseBuilder(
        context,
        MoviesSeriesDatabase::class.java, "Tourism.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideFilmDao(database: MoviesSeriesDatabase) = database.movieSeriesDao()
}