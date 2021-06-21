package dicoding.mobileprogramming.faishalammar.core.data.source.remote.network

import dicoding.mobileprogramming.faishalammar.core.data.source.remote.response.*
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getListMovies(@Query("api_key") api_key: String): Flowable<ListMovieResponse>

    @GET("tv/popular")
    fun getListTvSeries(@Query("api_key") api_key: String): Flowable<ListTvResponse>

    @GET("genre/tv/list")
    fun getTvGenre(@Query("api_key") api_key: String): Flowable<ListGenreResponse>

    @GET("genre/movie/list")
    fun getMovieGenre(@Query("api_key") api_key: String): Flowable<ListGenreResponse>

    @GET("movie/{id}")
    fun getMovieDetail(@Path("id") movieId : Int, @Query("api_key") api_key: String): Flowable<MovieResponse>

    @GET("tv/{id}")
    fun getSeriesDetail(@Path("id") movieId : Int, @Query("api_key") api_key: String ): Flowable<TvSeriesResponse>

}