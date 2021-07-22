package dicoding.mobileprogramming.faishalammar.imdc.presentation.adapter

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dicoding.mobileprogramming.faishalammar.core.databinding.FilmItemRowBinding
import dicoding.mobileprogramming.faishalammar.imdc.R
import dicoding.mobileprogramming.faishalammar.core.domain.model.Movie


class MovieListAdapter(val appContext: Context): RecyclerView.Adapter<MovieListAdapter.FilmViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback
    private var _binding: FilmItemRowBinding? = null
    private val binding get() = _binding!!
    private val listMovie : ArrayList<Movie> = ArrayList()


    fun setData(items: ArrayList<Movie>?) {
        listMovie.clear()
        if (items != null) {
            listMovie.addAll(items)
        }
        notifyDataSetChanged()
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): FilmViewHolder {

        val inflater: LayoutInflater = LayoutInflater.from(viewGroup.context)

        _binding = FilmItemRowBinding.inflate(inflater, viewGroup, false)
        val view = binding.root
                
        return FilmViewHolder(view)
    }



    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {

        val film = listMovie[position]

        val filmAvatar = "${dicoding.mobileprogramming.faishalammar.core.data.source.remote.RemoteDataSource.IMAGE_DOMAIN}${film.posterImg}"

        val options: RequestOptions = RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .override(67, 98)
                .error(R.drawable.ic_launcher_background)


        Glide.with(holder.itemView.context)
                .load(filmAvatar)
                .apply(options)
                .into(holder.filmPoster)

        holder.filmTitle.text = film.title

        holder.genreContainer.removeAllViews()
        val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(0, 0, 10, 0)


        var genreTextLength  = 0

        val newLL = LinearLayout(appContext)
        newLL.layoutParams = holder.genreContainer.layoutParams


        for((textViewId, genre) in film.genre.withIndex()){

            genreTextLength += genre.length

            val genreColor: Int = R.color.primaryYellow

            val layoutInflater: LayoutInflater = LayoutInflater.from(appContext)
            val genreBoxView: View = layoutInflater.inflate(R.layout.genre_box, null)
            val genreTextView: TextView = genreBoxView.findViewById(R.id.genre)
            genreTextView.layoutParams = params

            genreTextView.text = genre
            genreTextView.background = ColorDrawable(ContextCompat.getColor(appContext, genreColor))
            genreTextView.id = textViewId

            if(genreTextLength < 20){
                holder.genreContainer.addView(genreTextView)
            }

            else if(genreTextLength >= 20) {
                newLL.addView(genreTextView)

                if(textViewId == genre.length - 1) {
                    binding.genreLinearLayoutBox.addView(newLL)
                }


            }




        }

        if (!film.isFavourite) {
            holder.favButton.setImageResource(R.drawable.ic_favorite_border_white_24dp)
        } else {
            holder.favButton.setImageResource(R.drawable.ic_favorite_white_24dp)
        }

        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(film)
        }

        holder.favButton.setOnClickListener{
            onItemClickCallback.onFavButtonClicked(film)
            changeFavButtonIcon(holder, film.isFavourite)
        }



    }



    inner class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var filmPoster: ImageView = binding.filmPoster
        var filmTitle: TextView = binding.filmTitle
        var genreContainer : LinearLayout = binding.genreLinearLayout
        var genreContainerBox : LinearLayout = binding.genreLinearLayoutBox
        var favButton : ImageButton = binding.favButton

    }

    interface OnItemClickCallback {
        fun onItemClicked(film : Movie)
        fun onFavButtonClicked(film : Movie)
    }

    private fun changeFavButtonIcon(holder: FilmViewHolder, selectedFilmIsFav : Boolean) {
        if (selectedFilmIsFav) {
            holder.favButton.setImageResource(R.drawable.ic_favorite_border_white_24dp)
        } else {
            holder.favButton.setImageResource(R.drawable.ic_favorite_white_24dp)
        }
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }
}