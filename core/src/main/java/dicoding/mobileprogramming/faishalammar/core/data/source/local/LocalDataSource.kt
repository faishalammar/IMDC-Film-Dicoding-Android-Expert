package dicoding.mobileprogramming.faishalammar.core.data.source.local

import dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.GenreEntity
import dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity
import dicoding.mobileprogramming.faishalammar.core.data.source.local.room.MovieSeriesDao
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val mFilmDao: MovieSeriesDao) {

    fun getFilm(filmId : String) : Flowable<MoviesAndTvShowsEntity> = mFilmDao.getFilm(filmId)

    fun getAllMovies(): Flowable<List<MoviesAndTvShowsEntity>> = mFilmDao.getAllMovie()

    fun getAllSeries(): Flowable<List<MoviesAndTvShowsEntity>> = mFilmDao.getAllSeries()

    fun getFavouriteMovies(): Flowable<List<MoviesAndTvShowsEntity>> = mFilmDao.getAllFavouriteMovie()

    fun getFavouriteSeries(): Flowable<List<MoviesAndTvShowsEntity>> = mFilmDao.getAllFavouriteSeries()

    fun addFilmToFavourite(filmId: String) = mFilmDao.addFilmToFavourite(filmId)

    fun removeFilmFromFavourite(filmId: String) = mFilmDao.removeFilmFromFavourite(filmId)

    fun insertFilm(film : MoviesAndTvShowsEntity) = mFilmDao.insertFilm(film)

    fun insertGenre(genre : GenreEntity) = mFilmDao.insertGenre(genre)

    fun getGenreDetail(genreId: Int): Flowable<GenreEntity> = mFilmDao.getGenreDetail(genreId)

}