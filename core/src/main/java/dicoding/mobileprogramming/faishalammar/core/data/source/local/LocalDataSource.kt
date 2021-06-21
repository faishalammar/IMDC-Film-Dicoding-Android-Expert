package dicoding.mobileprogramming.faishalammar.core.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.GenreEntity
import dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity
import dicoding.mobileprogramming.faishalammar.core.data.source.local.room.MovieSeriesDao
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val mFilmDao: dicoding.mobileprogramming.faishalammar.core.data.source.local.room.MovieSeriesDao) {

    fun getFilm(filmId : String) : Flowable<dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity> = mFilmDao.getFilm(filmId)

    fun getAllMovies(): Flowable<List<dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity>> = mFilmDao.getAllMovie()

    fun getAllSeries(): Flowable<List<dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity>> = mFilmDao.getAllSeries()

    fun getFavouriteMovies(): Flowable<List<dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity>> = mFilmDao.getAllFavouriteMovie()

    fun getFavouriteSeries(): Flowable<List<dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity>> = mFilmDao.getAllFavouriteSeries()

    fun addFilmToFavourite(filmId: String) = mFilmDao.addFilmToFavourite(filmId)

    fun removeFilmFromFavourite(filmId: String) = mFilmDao.removeFilmFromFavourite(filmId)

    fun insertFilm(film : dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity) = mFilmDao.insertFilm(film)

    fun insertGenre(genre : dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.GenreEntity) = mFilmDao.insertGenre(genre)

    fun getGenreDetail(genreId: Int): Flowable<dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.GenreEntity> = mFilmDao.getGenreDetail(genreId)

}