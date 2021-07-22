package dicoding.mobileprogramming.faishalammar.core.data.source.local.room

import androidx.room.*
import dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.GenreEntity
import dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface MovieSeriesDao {

    @Query("SELECT * FROM film WHERE isMovie = 1")
    fun getAllMovie(): Flowable<List<MoviesAndTvShowsEntity>>

    @Query("SELECT * FROM film WHERE isMovie = 0")
    fun getAllSeries(): Flowable<List<MoviesAndTvShowsEntity>>

    @Query("SELECT * FROM film WHERE id = :filmId")
    fun getFilm(filmId: String): Flowable<MoviesAndTvShowsEntity>

    @Query("SELECT * FROM film WHERE isMovie = 1 AND isFavourite=1")
    fun getAllFavouriteMovie(): Flowable<List<MoviesAndTvShowsEntity>>

    @Query("SELECT * FROM film WHERE isMovie = 0 AND isFavourite=1")
    fun getAllFavouriteSeries(): Flowable<List<MoviesAndTvShowsEntity>>

    @Query("SELECT * FROM genre WHERE id = :genreId")
    fun getGenreDetail(genreId: Int): Flowable<GenreEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertListFilm(listFilm: List<MoviesAndTvShowsEntity>) : Completable

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertFilm(film: MoviesAndTvShowsEntity) : Completable

    @Update
    fun updateFilm(film: MoviesAndTvShowsEntity)

    @Query("UPDATE film SET isFavourite = 1 WHERE id = :filmId")
    fun addFilmToFavourite(filmId: String)

    @Query("UPDATE film SET isFavourite = 0 WHERE id = :filmId")
    fun removeFilmFromFavourite(filmId: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenre(genre: GenreEntity): Completable

}