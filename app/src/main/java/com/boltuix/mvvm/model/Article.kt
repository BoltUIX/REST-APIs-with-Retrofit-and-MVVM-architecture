package com.boltuix.mvvm.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Entity(tableName = "favorite_article")
@Parcelize
data class Article(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
   // @Ignore val pagedLists: Source,
    val title: String?,
    val url: String?,
    val urlToImage: String?
): Parcelable {

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0

}

