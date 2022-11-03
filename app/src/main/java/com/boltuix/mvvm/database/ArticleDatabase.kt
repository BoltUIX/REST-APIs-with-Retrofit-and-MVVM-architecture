package com.boltuix.mvvm.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.boltuix.mvvm.model.Article

@Database(
    entities = [Article::class],
    version = 1
)
abstract class ArticleDatabase : RoomDatabase(){
    abstract fun getArticleDao(): ArticleDao
}