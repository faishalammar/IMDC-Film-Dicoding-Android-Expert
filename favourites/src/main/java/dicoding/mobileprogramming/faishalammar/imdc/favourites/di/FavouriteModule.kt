package dicoding.mobileprogramming.faishalammar.imdc.favourites.di

import dagger.Binds
import dagger.Module
import dicoding.mobileprogramming.faishalammar.core.domain.usecase.FilmInteractor
import dicoding.mobileprogramming.faishalammar.core.domain.usecase.FilmUseCase


@Module
abstract class FavouriteModule {

    @Binds
    abstract fun provideFilmUseCase(filmInteractor: FilmInteractor): FilmUseCase

}