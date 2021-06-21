package dicoding.mobileprogramming.faishalammar.imdc.presentation.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dicoding.mobileprogramming.faishalammar.imdc.R
import dicoding.mobileprogramming.faishalammar.core.domain.model.Series
import dicoding.mobileprogramming.faishalammar.imdc.MyApplication
import dicoding.mobileprogramming.faishalammar.imdc.databinding.FragmentTvSeriesListBinding
import dicoding.mobileprogramming.faishalammar.imdc.presentation.activity.MovieAndTvSeriesDetailActivity
import dicoding.mobileprogramming.faishalammar.imdc.presentation.adapter.SeriesListAdapter
import dicoding.mobileprogramming.faishalammar.imdc.presentation.viewmodel.FilmListViewModel
import dicoding.mobileprogramming.faishalammar.core.ui.viewmodel.ViewModelFactory
import javax.inject.Inject
import kotlin.concurrent.thread


class TvSeriesListFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val filmListViewModel: FilmListViewModel by viewModels {
        factory
    }


    private lateinit var fragmentTvSeriesListBinding: FragmentTvSeriesListBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentTvSeriesListBinding = FragmentTvSeriesListBinding.inflate(layoutInflater, container, false)
        val activityContext : Context = activity?.applicationContext!!

        val seriesAdapter = SeriesListAdapter(activityContext)

        filmListViewModel.getSeries().observe(viewLifecycleOwner, { listMovie ->
            if (listMovie != null){
                seriesAdapter.setData(listMovie.data as ArrayList<Series>?)
                seriesAdapter.notifyDataSetChanged()
            }
        })

        with(fragmentTvSeriesListBinding.rvSeries) {
            layoutManager = LinearLayoutManager(activityContext)
            setHasFixedSize(true)
            adapter = seriesAdapter
        }

        /*
        Movies Click to Show Detail
         */

        seriesAdapter.setOnItemClickCallback(object :
            SeriesListAdapter.OnItemClickCallback {

            override fun onItemClicked(film: Series) {
                showSeriesDetail(film)
            }

            override fun onFavButtonClicked(
                film : Series
            ) {
                if (film.isFavourite) {
                    deleteFavouriteFilm(film)
                } else {
                    addFavouriteFilm(film)
                }
            }
        }
        )

        return fragmentTvSeriesListBinding.root
    }


    private fun showSeriesDetail(film: Series) {
        val intent = Intent(activity, MovieAndTvSeriesDetailActivity::class.java)
        val movie: Series = film
        val mBundle = Bundle()
        mBundle.putParcelable(MovieAndTvSeriesDetailActivity.EXTRA_SERIES, movie)
        intent.putExtras(mBundle)
        startActivity(intent)
    }

    private fun addFavouriteFilm(film: Series) {
        thread(start = true){
            filmListViewModel.addFilmToFavourite(film.id)
        }
        Toast.makeText(
                context,
                getString(R.string.add_favourite_film, film.title),
                Toast.LENGTH_SHORT
        ).show()
    }

    private fun deleteFavouriteFilm(film: Series) {
        thread(start = true){
            filmListViewModel.removeFilmFromFavourite(film.id)
        }
        Toast.makeText(
                context,
                getString(R.string.delete_favourite_film, film.title),
                Toast.LENGTH_SHORT
        ).show()
    }

}