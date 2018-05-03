package fr.dabernat.veillejs.vo

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Depending on how you access the data, you might want to index certain fields in the database
 * to speed up your queries. To add indices to an entity, include the indices property within
 * the @Entity annotation, listing the names of the columns that you want to include in the index
 * or composite index. The following code snippet demonstrates this annotation process:
 */
@Entity(tableName = "posts",
        indices = [Index("subreddit")])
data class VeilleJsPost(
        @PrimaryKey
        @SerializedName("name")
        val name: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("score")
        val score: Int,
        @SerializedName("author")
        val author: String,
        @SerializedName("subreddit") // this seems mutable but fine for a demo
        @ColumnInfo(collate = ColumnInfo.NOCASE)
        val subreddit: String,
        @SerializedName("num_comments")
        val num_comments: Int,
        @SerializedName("created_utc")
        val created: Long,
        val thumbnail: String?,
        val url: String?) {
    // to be consistent w/ changing backend order, we need to keep a data like this
    var indexInResponse: Int = -1
}