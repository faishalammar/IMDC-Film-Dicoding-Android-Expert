package dicoding.mobileprogramming.faishalammar.imdc.presentation.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dicoding.mobileprogramming.faishalammar.imdc.MyApplication
import dicoding.mobileprogramming.faishalammar.imdc.R
import dicoding.mobileprogramming.faishalammar.core.domain.model.Movie
import dicoding.mobileprogramming.faishalammar.core.ui.viewmodel.ViewModelFactory
import dicoding.mobileprogramming.faishalammar.imdc.databinding.FragmentMovieListBinding
import dicoding.mobileprogramming.faishalammar.imdc.presentation.activity.MovieAndTvSeriesDetailActivity
import dicoding.mobileprogramming.faishalammar.imdc.presentation.adapter.MovieListAdapter
import dicoding.mobileprogramming.faishalammar.imdc.presentation.viewmodel.FilmListViewModel
import javax.inject.Inject
import kotlin.concurrent.thread


class MovieListFragment : Fragment() {

    private lateinit var fragmentMovieListBinding: FragmentMovieListBinding
    private var moviesAdapter: MovieListAdapter? = null

    @Inject
    lateinit var factory: ViewModelFactory

    private val filmListViewModel: FilmListViewModel by viewModels {
        factory
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMovieListBinding =
            FragmentMovieListBinding.inflate(layoutInflater, container, false)

        val activityContext: Context = activity?.applicationContext!!
        moviesAdapter = MovieListAdapter(activityContext)


        with(fragmentMovieListBinding.rvMovie) {
            layoutManager = LinearLayoutManager(activityContext)
            setHasFixedSize(true)
            adapter = moviesAdapter
        }


        filmListViewModel.getMovies().observe(viewLifecycleOwner, { listMovie ->
            if (listMovie != null) {
                moviesAdapter!!.setData(listMovie.data as ArrayList<Movie>?)
                moviesAdapter!!.notifyDataSetChanged()
            }
        })


        /*
        Movies Click to Show Detail
         */

        moviesAdapter!!.setOnItemClickCallback(object :
            MovieListAdapter.OnItemClickCallback {
            override fun onItemClicked(film: Movie) {
                showMovieDetail(film)
            }

            override fun onFavButtonClicked(film: Movie) {
                if (film.isFavourite) {
                    deleteFavouriteFilm(film)
                } else {
                    addFavouriteFilm(film)
                }
            }

        }

        )

        return fragmentMovieListBinding.root
    }


    private fun showMovieDetail(film: Movie) {
        val intent = Intent(activity, MovieAndTvSeriesDetailActivity::class.java)
        val mBundle = Bundle()
        mBundle.putParcelable(MovieAndTvSeriesDetailActivity.EXTRA_MOVIE, film)
        intent.putExtras(mBundle)
        startActivity(intent)
    }

    private fun addFavouriteFilm(film: Movie) {
        thread(start = true) {
            filmListViewModel.addFilmToFavourite(film.id)
        }
        Toast.makeText(
            context,
            getString(R.string.add_favourite_film, film.title),
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun deleteFavouriteFilm(film: Movie) {
        thread(start = true) {
            filmListViewModel.removeFilmFromFavourite(film.id)
        }
        Toast.makeText(
            context,
            getString(R.string.delete_favourite_film, film.title),
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        moviesAdapter = null
    }


}