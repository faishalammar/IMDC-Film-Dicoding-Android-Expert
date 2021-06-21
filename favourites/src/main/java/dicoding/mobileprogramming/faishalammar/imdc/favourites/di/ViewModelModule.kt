package dicoding.mobileprogramming.faishalammar.imdc.favourites.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dicoding.mobileprogramming.faishalammar.core.ui.viewmodel.ViewModelFactory
import dicoding.mobileprogramming.faishalammar.imdc.favourites.presentation.viewmodel.FilmFavouriteViewModel
import dicoding.mobileprogramming.faishalammar.imdc.presentation.viewmodel.FilmDetailViewModel
import dicoding.mobileprogramming.faishalammar.imdc.presentation.viewmodel.FilmListViewModel

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(FilmFavouriteViewModel::class)
    abstract fun bindFavouriteViewModel(viewModel: FilmFavouriteViewModel): ViewModel
}