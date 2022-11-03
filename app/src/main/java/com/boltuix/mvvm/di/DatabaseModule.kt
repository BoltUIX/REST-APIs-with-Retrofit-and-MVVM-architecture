package com.boltuix.mvvm.di

import android.content.Context
import androidx.room.Room
import com.boltuix.mvvm.database.ArticleDao
import com.boltuix.mvvm.database.ArticleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): ArticleDatabase {
        return Room.databaseBuilder(
            appContext,
            ArticleDatabase::class.java,
            "app8.db"
        ).build()
    }

    @Provides
    fun provideMovieDao(appDatabase: ArticleDatabase): ArticleDao {
        return appDatabase.getArticleDao()
    }
}