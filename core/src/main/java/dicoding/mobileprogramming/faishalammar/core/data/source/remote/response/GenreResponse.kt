package dicoding.mobileprogramming.faishalammar.core.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class GenreResponse(
        @SerializedName("id")
        val id: Int,

        @SerializedName("name")
        val name: String,
) : Parcelable