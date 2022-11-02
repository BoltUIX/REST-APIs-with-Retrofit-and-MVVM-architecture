package com.boltuix.mvvm.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize



@Parcelize
data class NewResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
): Parcelable