package com.boltuix.mvvm.di

import android.content.Context
import androidx.room.Room
import com.boltuix.mvvm.database.FavoriteMovieDao
import com.boltuix.mvvm.database.FavoriteMovieDatabase
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
    fun provideAppDatabase(@ApplicationContext appContext: Context): FavoriteMovieDatabase {
        return Room.databaseBuilder(
            appContext,
            FavoriteMovieDatabase::class.java,
            "app8.db"
        ).build()
    }

    @Provides
    fun provideMovieDao(appDatabase: FavoriteMovieDatabase): FavoriteMovieDao {
        return appDatabase.getFavoriteMovieDao()
    }
}