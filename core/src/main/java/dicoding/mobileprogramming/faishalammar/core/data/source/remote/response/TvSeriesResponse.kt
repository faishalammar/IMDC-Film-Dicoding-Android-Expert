package dicoding.mobileprogramming.faishalammar.core.data.source.remote.response
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvSeriesResponse (
        @SerializedName("id")
        var id: String,

        @SerializedName("original_name")
        var title: String,

        @SerializedName("overview")
        var overview: String,

        @SerializedName("vote_average")
        var rating: Float,

        @SerializedName("poster_path")
        var posterImg: String,

        @SerializedName("genre_ids")
        var genre: ArrayList<String>,

        @SerializedName("genres")
        var listGenre : ArrayList<GenreResponse>
) : Parcelable