package dicoding.mobileprogramming.faishalammar.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dicoding.mobileprogramming.faishalammar.core.data.source.local.room.MoviesSeriesDatabase
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
class  DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): MoviesSeriesDatabase {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("dicoding".toCharArray())
        val factory = SupportFactory(passphrase)
        return Room.databaseBuilder(
            context,
            MoviesSeriesDatabase::class.java, "Tourism.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }

    @Provides
    fun provideFilmDao(database: MoviesSeriesDatabase) = database.movieSeriesDao()
}