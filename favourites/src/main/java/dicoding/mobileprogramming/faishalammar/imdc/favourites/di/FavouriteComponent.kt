package dicoding.mobileprogramming.faishalammar.imdc.favourites.di

import dagger.Component
import dicoding.mobileprogramming.faishalammar.core.di.CoreComponent
import dicoding.mobileprogramming.faishalammar.imdc.favourites.presentation.fragment.FavouriteFragment
import dicoding.mobileprogramming.faishalammar.imdc.favourites.presentation.fragment.MovieFavouriteFragment
import dicoding.mobileprogramming.faishalammar.imdc.favourites.presentation.fragment.TvSeriesFavouriteFragment

@FavouriteScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [FavouriteModule::class, ViewModelModule::class]
)
interface FavouriteComponent {
    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent ): FavouriteComponent
    }
    fun inject(fragment: FavouriteFragment)
    fun inject(fragment: MovieFavouriteFragment)
    fun inject(fragment: TvSeriesFavouriteFragment)
}