package dicoding.mobileprogramming.faishalammar.imdc.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dicoding.mobileprogramming.faishalammar.imdc.MyApplication
import dicoding.mobileprogramming.faishalammar.imdc.R
import dicoding.mobileprogramming.faishalammar.core.domain.model.Movie
import dicoding.mobileprogramming.faishalammar.core.domain.model.Series
import dicoding.mobileprogramming.faishalammar.imdc.databinding.ActivityMovieDetailBinding
import dicoding.mobileprogramming.faishalammar.imdc.presentation.viewmodel.FilmDetailViewModel
import dicoding.mobileprogramming.faishalammar.core.ui.viewmodel.ViewModelFactory
import javax.inject.Inject

class MovieAndTvSeriesDetailActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory


    private val filmDetailViewModel: FilmDetailViewModel by viewModels {
        factory
    }

    private var _binding: ActivityMovieDetailBinding? = null
    private val binding get() = _binding!!
    private var movie : Movie? = null
    private var series : Series? = null

    companion object {
        const val EXTRA_MOVIE = "EXTRA_MOVIE"
        const val EXTRA_SERIES = "EXTRA_SERIES"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        // Inflate the layout for this fragment
        _binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        val view = binding.root
        
        movie = intent.extras?.getParcelable(EXTRA_MOVIE)
        series = intent.extras?.getParcelable(EXTRA_SERIES)


        if(movie!=null){
            filmDetailViewModel.getMovieDetail(movieId = movie!!.id.toInt()).observe({lifecycle}, { movieObserved->
                if(movieObserved!=null){
                    movie = movieObserved.data!!
                    binding.filmDescriptionDetail.text = movie!!.overview
                    binding.filmDetailTitle.text = movie!!.title
                    binding.filmDetailRating.text = movie!!.rating.toString()

                    var genreString = ""
                    for(genre in movie!!.genre){
                        genreString += "$genre | "
                    }


                    binding.filmDetailGenre.text = genreString

                    val options: RequestOptions = RequestOptions()
                            .centerCrop()
                            .placeholder(R.drawable.ic_launcher_background)
                            .override(binding.filmDetailPoster.width, binding.filmDetailPoster.height)
                            .error(R.drawable.ic_launcher_background)

                    val filmAvatar = "${dicoding.mobileprogramming.faishalammar.core.data.source.remote.RemoteDataSource.IMAGE_DOMAIN}${movie!!.posterImg}"

                    Glide.with(applicationContext)
                            .load(filmAvatar)
                            .apply(options)
                            .into(binding.filmDetailPoster)


                }
            })
        } else {
            filmDetailViewModel.getSeriesDetail(seriesId = series!!.id.toInt()).observe({lifecycle}, { seriesObserved->
                if(seriesObserved!=null){
                    series = seriesObserved.data!!
                    binding.filmDescriptionDetail.text = series!!.overview
                    binding.filmDetailTitle.text = series!!.title
                    binding.filmDetailRating.text = series!!.rating.toString()

                    var genreString = ""
                    for(genre in series!!.genre){
                        genreString += "$genre | "
                    }


                    binding.filmDetailGenre.text = genreString

                    val options: RequestOptions = RequestOptions()
                            .centerCrop()
                            .placeholder(R.drawable.ic_launcher_background)
                            .override(binding.filmDetailPoster.width, binding.filmDetailPoster.height)
                            .error(R.drawable.ic_launcher_background)

                    val filmAvatar  = "${dicoding.mobileprogramming.faishalammar.core.data.source.remote.RemoteDataSource.IMAGE_DOMAIN}${series!!.posterImg}"

                    Glide.with(applicationContext)
                            .load(filmAvatar)
                            .apply(options)
                            .into(binding.filmDetailPoster)


                    }
            })
        }


        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        setContentView(view)

    }
}