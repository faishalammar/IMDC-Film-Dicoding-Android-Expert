package dicoding.mobileprogramming.faishalammar.core.di

import dagger.Module
import dagger.Provides
import dicoding.mobileprogramming.faishalammar.core.data.MoviesSeriesRepository
import dicoding.mobileprogramming.faishalammar.core.data.source.local.LocalDataSource
import dicoding.mobileprogramming.faishalammar.core.data.source.remote.RemoteDataSource
import dicoding.mobileprogramming.faishalammar.core.domain.repository.IMoviesSeriesRepository
import dicoding.mobileprogramming.faishalammar.core.utils.AppExecutors
import javax.inject.Singleton

@Module(includes = [NetworkModule::class, DatabaseModule::class])
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        remote: RemoteDataSource,
        local: LocalDataSource,
        executors: AppExecutors
    ): IMoviesSeriesRepository = MoviesSeriesRepository(remote, local, executors)

}