package dicoding.mobileprogramming.faishalammar.core.data.source.remote

import android.annotation.SuppressLint
import android.util.Log
import dicoding.mobileprogramming.faishalammar.core.data.source.remote.network.ApiService
import dicoding.mobileprogramming.faishalammar.core.data.source.remote.network.ApiResponse
import dicoding.mobileprogramming.faishalammar.core.data.source.remote.response.GenreResponse
import dicoding.mobileprogramming.faishalammar.core.data.source.remote.response.MovieResponse
import dicoding.mobileprogramming.faishalammar.core.data.source.remote.response.TvSeriesResponse
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    companion object {
        private const val API_KEY = "684d994290d5087d8c2f53a29a292a3a"
        const val IMAGE_DOMAIN = "https://image.tmdb.org/t/p/w500/"
    }
    
    @SuppressLint("CheckResult")
    fun getAllMovies() : Flowable<ApiResponse<List<MovieResponse>>> {
        val resultData = PublishSubject.create<ApiResponse<List<MovieResponse>>>()
        val client = apiService.getListMovies(API_KEY)

        client
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe ({ response ->
                Log.d("response", response.listMovies[0].title)
                val dataArray = response.listMovies
                resultData.onNext((if (dataArray.isNotEmpty()) ApiResponse.Success(dataArray) else ApiResponse.Empty))
            }, { error ->
                resultData.onNext(ApiResponse.Error(error.message.toString()))
                Log.e("DataSource Error > ", error.toString())
            })

        return resultData.toFlowable(BackpressureStrategy.BUFFER)
    }

    @SuppressLint("CheckResult")
    fun getAllSeries() : Flowable<ApiResponse<List<TvSeriesResponse>>> {
        val resultData = PublishSubject.create<ApiResponse<List<TvSeriesResponse>>>()
        val client = apiService.getListTvSeries(API_KEY)

        client
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe ({ response ->
                val dataArray = response?.listTvSeries
                if (dataArray != null) {
                    resultData.onNext((if (dataArray.isNotEmpty()) ApiResponse.Success(dataArray) else ApiResponse.Empty))
                }
            }, { error ->
                resultData.onNext(ApiResponse.Error(error.message.toString()))
                Log.e("RemoteDataSource", error.toString())
            })

        return resultData.toFlowable(BackpressureStrategy.BUFFER)
    }

    @SuppressLint("CheckResult")
    fun getMovieDetail(movieId : Int): Flowable<ApiResponse<MovieResponse>> {
        val resultData = PublishSubject.create<ApiResponse<MovieResponse>>()
        val client = apiService.getMovieDetail(movieId,
            API_KEY)

        client
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe ({ response ->
                val dataArray : MovieResponse = response
                resultData.onNext(ApiResponse.Success(dataArray))

            }, { error ->
                resultData.onNext(ApiResponse.Error(error.message.toString()))
                Log.e("RemoteDataSource", error.toString())
            })

        return resultData.toFlowable(BackpressureStrategy.BUFFER)
    }

    @SuppressLint("CheckResult")
    fun getSeriesDetail(seriesId : Int): Flowable<ApiResponse<TvSeriesResponse>> {

        val resultData = PublishSubject.create<ApiResponse<TvSeriesResponse>>()
        val client = apiService.getSeriesDetail(seriesId,
            API_KEY)

        client
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe ({ response ->
                val dataArray : TvSeriesResponse = response
                resultData.onNext(ApiResponse.Success(dataArray))

            }, { error ->
                resultData.onNext(ApiResponse.Error(error.message.toString()))
                Log.e("RemoteDataSource", error.toString())
            })

        return resultData.toFlowable(BackpressureStrategy.BUFFER)
    }

    @SuppressLint("CheckResult")
    fun getAllGenre(forMovie : Boolean) : Flowable<ApiResponse<List<GenreResponse>>> {
        val resultData = PublishSubject.create<ApiResponse<List<GenreResponse>>>()
        val client = (if(forMovie) apiService.getMovieGenre(API_KEY) else apiService.getTvGenre(
            API_KEY
        ))

        client
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe ({ response ->
                val dataArray : List<GenreResponse> = response.arrayListGenre!!
                resultData.onNext(ApiResponse.Success(dataArray))

            }, { error ->
                resultData.onNext(ApiResponse.Error(error.message.toString()))
                Log.e("RemoteDataSource", error.toString())
            })

        return resultData.toFlowable(BackpressureStrategy.BUFFER)
    }

}