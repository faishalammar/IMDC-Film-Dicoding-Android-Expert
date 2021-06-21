package dicoding.mobileprogramming.faishalammar.core.domain.usecase

import dicoding.mobileprogramming.faishalammar.core.domain.model.Movie
import dicoding.mobileprogramming.faishalammar.core.domain.model.Series
import dicoding.mobileprogramming.faishalammar.core.domain.repository.IMoviesSeriesRepository
import dicoding.mobileprogramming.faishalammar.core.utils.vo.Resource
import io.reactivex.Flowable
import javax.inject.Inject

class FilmInteractor @Inject constructor(private val moviesSeriesRepository: IMoviesSeriesRepository): FilmUseCase {
    override fun getAllMovies(): Flowable<Resource<List<Movie>>> {
       return moviesSeriesRepository.getAllMovies()
    }

    override fun getAllTvSeries(): Flowable<Resource<List<Series>>> {
        return moviesSeriesRepository.getAllTvSeries()
    }

    override fun getMovieDetail(movieId: Int): Flowable<Resource<Movie>> {
        return moviesSeriesRepository.getMovieDetail(movieId)
    }

    override fun getSeriesDetail(seriesId: Int): Flowable<Resource<Series>> {
        return moviesSeriesRepository.getSeriesDetail(seriesId)
    }

    override fun getFavouriteMovies(): Flowable<Resource<List<Movie>>> {
        return moviesSeriesRepository.getFavouriteMovies()
    }

    override fun getFavouriteSeries(): Flowable<Resource<List<Series>>> {
        return moviesSeriesRepository.getFavouriteSeries()
    }

    override fun addFilmToFavourite(filmId: String) {
        return moviesSeriesRepository.addFilmToFavourite(filmId)
    }

    override fun removeFilmFromFavourite(filmId: String) {
        return moviesSeriesRepository.removeFilmFromFavourite(filmId)
    }


}