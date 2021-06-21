package dicoding.mobileprogramming.faishalammar.imdc.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import dicoding.mobileprogramming.faishalammar.core.domain.model.Movie
import dicoding.mobileprogramming.faishalammar.core.domain.model.Series
import dicoding.mobileprogramming.faishalammar.core.domain.usecase.FilmUseCase
import dicoding.mobileprogramming.faishalammar.core.utils.vo.Resource
import javax.inject.Inject

class FilmListViewModel @Inject constructor(private val filmUseCase: FilmUseCase) : ViewModel() {
    fun getMovies(): LiveData<Resource<List<Movie>>> = LiveDataReactiveStreams.fromPublisher(filmUseCase.getAllMovies())
    fun getSeries(): LiveData<Resource<List<Series>>> = LiveDataReactiveStreams.fromPublisher(filmUseCase.getAllTvSeries())
    fun addFilmToFavourite(filmId : String) = filmUseCase.addFilmToFavourite(filmId)
    fun removeFilmFromFavourite(filmId: String) = filmUseCase.removeFilmFromFavourite(filmId)
}