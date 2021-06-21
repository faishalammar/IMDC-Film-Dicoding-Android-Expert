package dicoding.mobileprogramming.faishalammar.core.utils
import dicoding.mobileprogramming.faishalammar.core.domain.model.Genre
import dicoding.mobileprogramming.faishalammar.core.domain.model.Movie
import dicoding.mobileprogramming.faishalammar.core.domain.model.Series

object DataMapper {
    fun mapMoviesEntitiesToDomain(input: List<dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity>): List<Movie> =
            input.map {
                Movie(
                        id = it.id,
                        title = it.title,
                        overview = it.overview,
                        rating = it.rating,
                        posterImg = it.posterImg,
                        genre = it.genre,
                        isMovies = true,
                        isFavourite = it.isFavourite
                )
            }

    fun mapMoviesDomainToEntity(input: Movie) =
        dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity(
            id = input.id,
            title = input.title,
            overview = input.overview,
            rating = input.rating,
            posterImg = input.posterImg,
            genre = input.genre,
            isMovies = true,
            isFavourite = input.isFavourite
        )

    fun mapSeriesEntitiesToDomain(input: List<dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity>): List<Series> =
            input.map {
                Series(
                        id = it.id,
                        title = it.title,
                        overview = it.overview,
                        rating = it.rating,
                        posterImg = it.posterImg,
                        genre = it.genre,
                        isMovies = false,
                        isFavourite = it.isFavourite
                )
            }

    fun mapSeriesDomainToEntity(input: Series) =
        dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.MoviesAndTvShowsEntity(
            id = input.id,
            title = input.title,
            overview = input.overview,
            rating = input.rating,
            posterImg = input.posterImg,
            genre = input.genre,
            isMovies = false,
            isFavourite = input.isFavourite
        )

    fun mapGenreEntitiesToDomain(input: List<dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.GenreEntity>): List<Genre> =
        input.map {
            Genre(
                id = it.id,
                name = it.name
            )
        }

    fun mapGenreDomainToEntity(input: Genre) =
        dicoding.mobileprogramming.faishalammar.core.data.source.local.entity.GenreEntity(
            id = input.id,
            name = input.name
        )

}

