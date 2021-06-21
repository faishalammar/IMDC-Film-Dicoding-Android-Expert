package dicoding.mobileprogramming.faishalammar.core.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dicoding.mobileprogramming.faishalammar.core.domain.repository.IMoviesSeriesRepository
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RepositoryModule::class]
)
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoreComponent
    }

    fun provideRepository() : IMoviesSeriesRepository
}