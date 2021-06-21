package dicoding.mobileprogramming.faishalammar.core.data.source.local.entity
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Film")
data class MoviesAndTvShowsEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "id")
        var id: String,

        @NonNull
        @ColumnInfo(name = "title")
        var title: String,

        @NonNull
        @ColumnInfo(name = "overview")
        var overview: String,

        @NonNull
        @ColumnInfo(name = "rating")
        var rating: Float,

        @NonNull
        @ColumnInfo(name = "posterImg")
        var posterImg: String,

        @NonNull
        @ColumnInfo(name = "listGenre")
        var genre: ArrayList<String>,

        @NonNull
        @ColumnInfo(name = "isMovie")
        var isMovies: Boolean,

        @NonNull
        @ColumnInfo(name = "isFavourite")
        var isFavourite: Boolean = false

) : Parcelable
