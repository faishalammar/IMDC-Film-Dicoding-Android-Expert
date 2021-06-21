package dicoding.mobileprogramming.faishalammar.imdc.favourites.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dicoding.mobileprogramming.faishalammar.core.di.DaggerCoreComponent
import dicoding.mobileprogramming.faishalammar.core.domain.model.Movie
import dicoding.mobileprogramming.faishalammar.core.ui.viewmodel.ViewModelFactory
import dicoding.mobileprogramming.faishalammar.imdc.R
import dicoding.mobileprogramming.faishalammar.imdc.favourites.databinding.FragmentMovieFavouriteBinding
import dicoding.mobileprogramming.faishalammar.imdc.favourites.di.DaggerFavouriteComponent
import dicoding.mobileprogramming.faishalammar.imdc.favourites.presentation.adapter.MovieFavouriteAdapter
import dicoding.mobileprogramming.faishalammar.imdc.favourites.presentation.viewmodel.FilmFavouriteViewModel
import javax.inject.Inject
import kotlin.concurrent.thread


class MovieFavouriteFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: FilmFavouriteViewModel by viewModels {
        factory
    }

    private lateinit var binding: FragmentMovieFavouriteBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)

        DaggerFavouriteComponent
            .factory()
            .create(DaggerCoreComponent.factory().create(context))
            .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMovieFavouriteBinding.inflate(layoutInflater, container, false)

        val activityContext : Context = activity?.applicationContext!!
        val moviesAdapter = MovieFavouriteAdapter(activityContext)
        Log.d("Success go to : ", "Favourite Movie Modules")

        with(binding.rvFavMovie) {
            layoutManager = LinearLayoutManager(activityContext)
            setHasFixedSize(true)
            adapter = moviesAdapter
        }


        viewModel.getFavouriteMovies().observe(viewLifecycleOwner, { listMovie ->
            Log.d("favourite movie >", listMovie.toString())
            moviesAdapter.setData(listMovie.data as ArrayList<Movie>?)
            moviesAdapter.notifyDataSetChanged()
        })


        moviesAdapter.setOnItemClickCallback(object :
            MovieFavouriteAdapter.OnItemClickCallback {
            override fun onItemClicked(film: Movie) {
            }

            override fun onDeleteButtonClicked(film: Movie) {
                deleteFavouriteFilm(film)
            }
        })

        return binding.root
    }

    private fun deleteFavouriteFilm(film: Movie) {
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
