package dicoding.mobileprogramming.faishalammar.imdc.di

import dagger.Component
import dicoding.mobileprogramming.faishalammar.core.di.CoreComponent
import dicoding.mobileprogramming.faishalammar.imdc.presentation.activity.HomeActivity
import dicoding.mobileprogramming.faishalammar.imdc.presentation.activity.MovieAndTvSeriesDetailActivity
import dicoding.mobileprogramming.faishalammar.imdc.presentation.fragment.*

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class, ViewModelModule::class]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(fragment: TvSeriesListFragment)
    fun inject(fragment: MovieListFragment)
    fun inject(activity: HomeActivity)
    fun inject(activity: MovieAndTvSeriesDetailActivity)

}