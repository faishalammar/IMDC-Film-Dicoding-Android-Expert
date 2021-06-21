package dicoding.mobileprogramming.faishalammar.core.data.source.local.entity
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Genre")
data class GenreEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "id")
        val id: Int,

        @NonNull
        @ColumnInfo(name = "name")
        val name: String,
) : Parcelable
