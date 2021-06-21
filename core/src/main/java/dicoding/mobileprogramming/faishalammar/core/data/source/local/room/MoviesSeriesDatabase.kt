package dicoding.mobileprogramming.faishalammar.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dicoding.mobileprogramming.faishalammar.core.utils.Converters

@Database(entities = [dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity::class, dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.GenreEntity::class],
        version = 3,
        exportSchema = false)
@TypeConverters(Converters::class)
abstract class MoviesSeriesDatabase : RoomDatabase(){
    abstract fun movieSeriesDao() : dicoding.mobileprogramming.faishalammar.core.data.source.local.room.MovieSeriesDao
}