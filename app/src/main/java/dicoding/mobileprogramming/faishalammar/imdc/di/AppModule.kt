package dicoding.mobileprogramming.faishalammar.imdc.di

import dagger.Binds
import dagger.Module
import dicoding.mobileprogramming.faishalammar.core.domain.usecase.FilmInteractor
import dicoding.mobileprogramming.faishalammar.core.domain.usecase.FilmUseCase


@Module
abstract class AppModule {

    @Binds
    abstract fun provideFilmUseCase(filmInteractor: FilmInteractor): FilmUseCase

}