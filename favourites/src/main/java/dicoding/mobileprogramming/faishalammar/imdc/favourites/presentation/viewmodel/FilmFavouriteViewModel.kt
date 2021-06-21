package dicoding.mobileprogramming.faishalammar.imdc.favourites.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import dicoding.mobileprogramming.faishalammar.core.domain.model.Movie
import dicoding.mobileprogramming.faishalammar.core.domain.model.Series
import dicoding.mobileprogramming.faishalammar.core.domain.usecase.FilmUseCase
import dicoding.mobileprogramming.faishalammar.core.utils.vo.Resource
import javax.inject.Inject

class FilmFavouriteViewModel @Inject constructor(private val filmUseCase: FilmUseCase) : ViewModel() {
    fun getFavouriteSeries(): LiveData<Resource<List<Series>>> = LiveDataReactiveStreams.fromPublisher(filmUseCase.getFavouriteSeries())
    fun getFavouriteMovies(): LiveData<Resource<List<Movie>>> = LiveDataReactiveStreams.fromPublisher(filmUseCase.getFavouriteMovies())
    fun addFilmToFavourite(filmId : String) = filmUseCase.addFilmToFavourite(filmId)
    fun removeFilmFromFavourite(filmId: String) = filmUseCase.removeFilmFromFavourite(filmId)
}