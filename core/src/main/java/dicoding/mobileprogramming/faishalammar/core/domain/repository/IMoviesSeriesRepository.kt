package dicoding.mobileprogramming.faishalammar.core.domain.repository

import androidx.lifecycle.LiveData
import dicoding.mobileprogramming.faishalammar.core.utils.vo.Resource
import dicoding.mobileprogramming.faishalammar.core.domain.model.Genre
import dicoding.mobileprogramming.faishalammar.core.domain.model.Movie
import dicoding.mobileprogramming.faishalammar.core.domain.model.Series
import io.reactivex.Flowable

interface IMoviesSeriesRepository {
    fun getAllMovies(): Flowable<Resource<List<Movie>>>
    fun getAllTvSeries(): Flowable<Resource<List<Series>>>
    fun getMovieDetail(movieId : Int) : Flowable<Resource<Movie>>
    fun getSeriesDetail(seriesId : Int) : Flowable<Resource<Series>>
    fun getFavouriteMovies() : Flowable<Resource<List<Movie>>>
    fun getFavouriteSeries() : Flowable<Resource<List<Series>>>
    fun addFilmToFavourite(filmId : String)
    fun removeFilmFromFavourite(filmId : String)
    fun getMovieGenre(genreId : Int) : Flowable<Resource<Genre>>
    fun getSeriesGenre(genreId : Int) : Flowable<Resource<Genre>>
}