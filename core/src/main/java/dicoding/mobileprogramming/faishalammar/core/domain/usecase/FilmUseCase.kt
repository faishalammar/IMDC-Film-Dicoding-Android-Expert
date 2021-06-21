package dicoding.mobileprogramming.faishalammar.core.domain.usecase

import dicoding.mobileprogramming.faishalammar.core.domain.model.Movie
import dicoding.mobileprogramming.faishalammar.core.domain.model.Series
import dicoding.mobileprogramming.faishalammar.core.utils.vo.Resource
import io.reactivex.Flowable

interface FilmUseCase {
    fun getAllMovies(): Flowable<Resource<List<Movie>>>
    fun getAllTvSeries(): Flowable<Resource<List<Series>>>
    fun getMovieDetail(movieId : Int) : Flowable<Resource<Movie>>
    fun getSeriesDetail(seriesId : Int) : Flowable<Resource<Series>>
    fun getFavouriteMovies() : Flowable<Resource<List<Movie>>>
    fun getFavouriteSeries() : Flowable<Resource<List<Series>>>
    fun addFilmToFavourite(filmId : String)
    fun removeFilmFromFavourite(filmId : String)
}