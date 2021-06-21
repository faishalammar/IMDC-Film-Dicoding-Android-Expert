package dicoding.mobileprogramming.faishalammar.imdc.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import dicoding.mobileprogramming.faishalammar.core.domain.model.Movie
import dicoding.mobileprogramming.faishalammar.core.domain.model.Series
import dicoding.mobileprogramming.faishalammar.core.domain.usecase.FilmUseCase
import dicoding.mobileprogramming.faishalammar.core.utils.vo.Resource
import javax.inject.Inject

class FilmDetailViewModel @Inject constructor(private val filmUseCase: FilmUseCase) : ViewModel() {
    fun getMovieDetail(movieId : Int): LiveData<Resource<Movie>> = LiveDataReactiveStreams.fromPublisher(filmUseCase.getMovieDetail(movieId))
    fun getSeriesDetail(seriesId : Int): LiveData<Resource<Series>> = LiveDataReactiveStreams.fromPublisher(filmUseCase.getSeriesDetail(seriesId))

}