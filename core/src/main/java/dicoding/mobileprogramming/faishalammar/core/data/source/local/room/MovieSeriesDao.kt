package dicoding.mobileprogramming.faishalammar.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.GenreEntity
import dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface MovieSeriesDao {

    @Query("SELECT * FROM film WHERE isMovie = 1")
    fun getAllMovie(): Flowable<List<dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity>>

    @Query("SELECT * FROM film WHERE isMovie = 0")
    fun getAllSeries(): Flowable<List<dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity>>

    @Query("SELECT * FROM film WHERE id = :filmId")
    fun getFilm(filmId: String): Flowable<dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity>

    @Query("SELECT * FROM film WHERE isMovie = 1 AND isFavourite=1")
    fun getAllFavouriteMovie(): Flowable<List<dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity>>

    @Query("SELECT * FROM film WHERE isMovie = 0 AND isFavourite=1")
    fun getAllFavouriteSeries(): Flowable<List<dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity>>

    @Query("SELECT * FROM genre WHERE id = :genreId")
    fun getGenreDetail(genreId: Int): Flowable<dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.GenreEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertListFilm(listFilm: List<dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity>) : Completable

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertFilm(film: dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity) : Completable

    @Update
    fun updateFilm(film: dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity)

    @Query("UPDATE film SET isFavourite = 1 WHERE id = :filmId")
    fun addFilmToFavourite(filmId: String)

    @Query("UPDATE film SET isFavourite = 0 WHERE id = :filmId")
    fun removeFilmFromFavourite(filmId: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenre(genre: dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.GenreEntity): Completable

}