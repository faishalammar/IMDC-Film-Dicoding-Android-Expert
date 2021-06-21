package dicoding.mobileprogramming.faishalammar.core.data


import dicoding.mobileprogramming.faishalammar.core.data.source.remote.network.ApiResponse
import dicoding.mobileprogramming.faishalammar.core.data.source.remote.response.GenreResponse
import dicoding.mobileprogramming.faishalammar.core.data.source.remote.response.MovieResponse
import dicoding.mobileprogramming.faishalammar.core.data.source.remote.response.TvSeriesResponse
import dicoding.mobileprogramming.faishalammar.core.domain.model.Genre
import dicoding.mobileprogramming.faishalammar.core.domain.model.Movie
import dicoding.mobileprogramming.faishalammar.core.domain.model.Series
import dicoding.mobileprogramming.faishalammar.core.domain.repository.IMoviesSeriesRepository
import dicoding.mobileprogramming.faishalammar.core.utils.AppExecutors
import dicoding.mobileprogramming.faishalammar.core.utils.DataMapper
import dicoding.mobileprogramming.faishalammar.core.utils.vo.Resource


import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesSeriesRepository @Inject constructor(
    private val remoteDataSource: dicoding.mobileprogramming.faishalammar.core.data.source.remote.RemoteDataSource,
    private val localDataSource: dicoding.mobileprogramming.faishalammar.core.data.source.local.LocalDataSource,
    private val appExecutors: AppExecutors
)
    : IMoviesSeriesRepository {


    override fun getAllMovies(): Flowable<Resource<List<Movie>>> {
        return object : dicoding.mobileprogramming.faishalammar.core.data.NetworkBoundResource<List<Movie>, List<MovieResponse>>() {
            public override fun loadFromDB(): Flowable<List<Movie>> {
                return localDataSource.getAllMovies().map{
                    DataMapper.mapMoviesEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean =
                    true

            public override fun createCall(): Flowable<ApiResponse<List<MovieResponse>>> =
                    remoteDataSource.getAllMovies()

            public override fun saveCallResult(data : List<MovieResponse>) {
                val movieList = ArrayList<dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity>()
                for (response in data) {
                    val movie =
                        dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity(
                            response.id,
                            response.title,
                            response.overview,
                            response.rating,
                            response.posterImg,
                            response.genre,
                            true
                        )

                    movieList.add(movie)
                    localDataSource.insertFilm(movie)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe()

                }

            }
        }.asFlowable()
    }

    override fun getAllTvSeries(): Flowable<Resource<List<Series>>> {
        return object : dicoding.mobileprogramming.faishalammar.core.data.NetworkBoundResource<List<Series>, List<TvSeriesResponse>>() {
            public override fun loadFromDB(): Flowable<List<Series>>{
                return localDataSource.getAllSeries().map {
                    DataMapper.mapSeriesEntitiesToDomain(it)
                }
            }
            override fun shouldFetch(data: List<Series>?): Boolean =
                    data == null || data.isEmpty()
            public override fun createCall(): Flowable<ApiResponse<List<TvSeriesResponse>>> =
                    remoteDataSource.getAllSeries()
            public override fun saveCallResult(data : List<TvSeriesResponse>) {
                val seriesList = ArrayList<dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity>()
                for (response in data) {

                    val series =
                        dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity(
                            response.id,
                            response.title,
                            response.overview,
                            response.rating,
                            response.posterImg,
                            response.genre,
                            false
                        )

                    seriesList.add(series)
                    localDataSource.insertFilm(series)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe()

                }

            }
        }.asFlowable()
    }

    override fun getMovieDetail(movieId: Int): Flowable<Resource<Movie>> {
        return object : dicoding.mobileprogramming.faishalammar.core.data.NetworkBoundResource<Movie, MovieResponse>() {
            public override fun loadFromDB(): Flowable<Movie> =
                localDataSource.getFilm(movieId.toString()).map{
                    val listMovieToConvert : List<dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity> = listOf(it)
                    DataMapper.mapMoviesEntitiesToDomain(listMovieToConvert)[0]
                }

            override fun shouldFetch(data: Movie?): Boolean =
                    data == null
            public override fun createCall(): Flowable<ApiResponse<MovieResponse>> =
                    remoteDataSource.getMovieDetail(movieId)
            public override fun saveCallResult(data : MovieResponse) {

                val movieDetail =
                    dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity(
                        data.id,
                        data.title,
                        data.overview,
                        data.rating,
                        data.posterImg,
                        data.genre,
                        true
                    )

                localDataSource.insertFilm(movieDetail)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            }
        }.asFlowable()
    }

    override fun getSeriesDetail(seriesId: Int): Flowable<Resource<Series>> {
        return object : dicoding.mobileprogramming.faishalammar.core.data.NetworkBoundResource<Series, TvSeriesResponse>() {
            public override fun loadFromDB(): Flowable<Series> =
                localDataSource.getFilm(seriesId.toString()).map {
                    val listSeriesToConvert : List<dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity> = listOf(it)
                    DataMapper.mapSeriesEntitiesToDomain(listSeriesToConvert)[0]
                }
            override fun shouldFetch(data: Series?): Boolean =
                    data == null
            public override fun createCall(): Flowable<ApiResponse<TvSeriesResponse>> =
                    remoteDataSource.getSeriesDetail(seriesId)
            public override fun saveCallResult(data : TvSeriesResponse) {
                val movieDetail =
                    dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity(
                        data.id,
                        data.title,
                        data.overview,
                        data.rating,
                        data.posterImg,
                        data.genre,
                        false
                    )
                localDataSource.insertFilm(movieDetail)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            }
        }.asFlowable()
    }

    override fun getFavouriteMovies(): Flowable<Resource<List<Movie>>> {
        return object : dicoding.mobileprogramming.faishalammar.core.data.NetworkBoundResource<List<Movie>, List<MovieResponse>>() {
            public override fun loadFromDB(): Flowable<List<Movie>> {
                return localDataSource.getFavouriteMovies().map{
                    DataMapper.mapMoviesEntitiesToDomain(it)
                }

            }
            override fun shouldFetch(data: List<Movie>?): Boolean =
                    false
            public override fun createCall(): Flowable<ApiResponse<List<MovieResponse>>> =
                    remoteDataSource.getAllMovies()
            public override fun saveCallResult(data : List<MovieResponse>) {
            }
        }.asFlowable()
    }

    override fun getFavouriteSeries(): Flowable<Resource<List<Series>>> {
        return object : dicoding.mobileprogramming.faishalammar.core.data.NetworkBoundResource<List<Series>, List<TvSeriesResponse>>() {
            public override fun loadFromDB(): Flowable<List<Series>> {
                return localDataSource.getFavouriteSeries().map {
                    DataMapper.mapSeriesEntitiesToDomain(it)
                }
            }
            override fun shouldFetch(data: List<Series>?): Boolean =
                    false
            public override fun createCall(): Flowable<ApiResponse<List<TvSeriesResponse>>> =
                    remoteDataSource.getAllSeries()
            public override fun saveCallResult(data : List<TvSeriesResponse>) {
            }
        }.asFlowable()
    }

    override fun getMovieGenre(genreId: Int): Flowable<Resource<Genre>> {
        return object : dicoding.mobileprogramming.faishalammar.core.data.NetworkBoundResource<Genre, List<GenreResponse>>() {
            public override fun loadFromDB(): Flowable<Genre> {
                return localDataSource.getGenreDetail(genreId).map {
                    DataMapper.mapGenreEntitiesToDomain(listOf(it))[0]
                }
            }
            public override fun shouldFetch(data: Genre?): Boolean =
                data == null

            public override fun createCall(): Flowable<ApiResponse<List<GenreResponse>>> =
                remoteDataSource.getAllGenre(true)

            public override fun saveCallResult(data: List<GenreResponse>) {
                for (genreResponse in data){
                    val genre : dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.GenreEntity =
                        dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.GenreEntity(
                            id = genreResponse.id,
                            name = genreResponse.name)
                    localDataSource.insertGenre(genre)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe()
                    }
                }
            }.asFlowable()
        }

    override fun getSeriesGenre(genreId: Int): Flowable<Resource<Genre>> {
        return object : dicoding.mobileprogramming.faishalammar.core.data.NetworkBoundResource<Genre, List<GenreResponse>>() {
            public override fun loadFromDB(): Flowable<Genre> {
                return localDataSource.getGenreDetail(genreId).map {
                    DataMapper.mapGenreEntitiesToDomain(listOf(it))[0]
                }
            }
            public override fun shouldFetch(data: Genre?): Boolean =
                data == null

            public override fun createCall(): Flowable<ApiResponse<List<GenreResponse>>> =
                remoteDataSource.getAllGenre(false)

            public override fun saveCallResult(data: List<GenreResponse>) {
                for (genreResponse in data){
                    val genre : dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.GenreEntity =
                        dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.GenreEntity(
                            id = genreResponse.id,
                            name = genreResponse.name)
                    localDataSource.insertGenre(genre)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe()
                }
            }
        }.asFlowable()
    }

    override fun addFilmToFavourite(filmId : String) {
        appExecutors.diskIO().execute { localDataSource.addFilmToFavourite(filmId) }
    }

    override fun removeFilmFromFavourite(filmId : String) {
        appExecutors.diskIO().execute { localDataSource.removeFilmFromFavourite(filmId) }
    }


}