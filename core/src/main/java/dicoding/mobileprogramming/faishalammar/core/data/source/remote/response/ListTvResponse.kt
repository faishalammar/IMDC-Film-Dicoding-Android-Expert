package dicoding.mobileprogramming.faishalammar.core.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class ListTvResponse(
    @SerializedName("page")
    val page: Int?,

    @SerializedName("results")
    val listTvSeries: List<TvSeriesResponse>?,
) : Parcelable