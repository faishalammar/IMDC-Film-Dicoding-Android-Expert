package dicoding.mobileprogramming.faishalammar.imdc.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dicoding.mobileprogramming.faishalammar.core.ui.viewmodel.ViewModelFactory
import dicoding.mobileprogramming.faishalammar.imdc.presentation.viewmodel.FilmDetailViewModel
import dicoding.mobileprogramming.faishalammar.imdc.presentation.viewmodel.FilmListViewModel

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(FilmDetailViewModel::class)
    abstract fun bindHomeViewModel(viewModel: FilmDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FilmListViewModel::class)
    abstract fun bindFavoriteViewModel(viewModel: FilmListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}