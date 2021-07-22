package dicoding.mobileprogramming.faishalammar.imdc.favourites.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dicoding.mobileprogramming.faishalammar.imdc.favourites.presentation.viewmodel.FilmFavouriteViewModel

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(FilmFavouriteViewModel::class)
    abstract fun bindFavouriteViewModel(viewModel: FilmFavouriteViewModel): ViewModel
}