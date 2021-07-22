package dicoding.mobileprogramming.faishalammar.imdc.favourites.presentation.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dicoding.mobileprogramming.faishalammar.core.di.DaggerCoreComponent
import dicoding.mobileprogramming.faishalammar.imdc.R
import dicoding.mobileprogramming.faishalammar.core.domain.model.Series
import dicoding.mobileprogramming.faishalammar.imdc.favourites.databinding.FragmentTvSeriesFavouriteBinding
import dicoding.mobileprogramming.faishalammar.imdc.favourites.di.DaggerFavouriteComponent
import dicoding.mobileprogramming.faishalammar.imdc.favourites.presentation.adapter.SeriesFavouriteAdapter
import dicoding.mobileprogramming.faishalammar.core.ui.viewmodel.ViewModelFactory
import javax.inject.Inject
import kotlin.concurrent.thread


class TvSeriesFavouriteFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: dicoding.mobileprogramming.faishalammar.imdc.favourites.presentation.viewmodel.FilmFavouriteViewModel by viewModels {
        factory
    }

    private lateinit var binding: FragmentTvSeriesFavouriteBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFavouriteComponent
            .factory()
            .create(DaggerCoreComponent.factory().create(context))
            .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTvSeriesFavouriteBinding.inflate(layoutInflater, container, false)

        val activityContext : Context = activity?.applicationContext!!
        val seriesAdapter =
            SeriesFavouriteAdapter(
                activityContext)

        with(binding.rvFavSeries) {
            layoutManager = LinearLayoutManager(activityContext)
            setHasFixedSize(true)
            adapter = seriesAdapter
        }

        viewModel.getFavouriteSeries().observe(viewLifecycleOwner, { listMovie ->
            if (listMovie != null){
                seriesAdapter.setData(listMovie.data as ArrayList<Series>)
                seriesAdapter.notifyDataSetChanged()
            }
        })

        seriesAdapter.setOnItemClickCallback(object :
            SeriesFavouriteAdapter.OnItemClickCallback {
            override fun onItemClicked(film: Series) {
            }

            override fun onDeleteButtonClicked(film: Series) {
                deleteFavouriteFilm(film)
            }


        })

        return binding.root
    }

    private fun deleteFavouriteFilm(film: Series) {
        Toast.makeText(
                context,
                getString(R.string.delete_favourite_film, film.title),
                Toast.LENGTH_SHORT
        ).show()
        thread(start = true){
            viewModel.removeFilmFromFavourite(film.id)
        }

    }

}
