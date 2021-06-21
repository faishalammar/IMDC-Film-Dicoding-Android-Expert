package dicoding.mobileprogramming.faishalammar.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Series(
        var id: String,
        var title: String,
        var overview: String,
        var rating: Float,
        var posterImg: String,
        var genre: ArrayList<String>,
        var isMovies: Boolean,
        var isFavourite: Boolean = false
) : Parcelable