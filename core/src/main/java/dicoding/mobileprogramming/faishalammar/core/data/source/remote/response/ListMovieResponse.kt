package dicoding.mobileprogramming.faishalammar.core.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class ListMovieResponse(
    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val listMovies: List<MovieResponse>,
) : Parcelable