package com.boltuix.mvvm.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferencesModules {

    @Provides
    fun providesSharedPreferences(context: Application): SharedPreferences {
        return context.getSharedPreferences("DB1", Context.MODE_PRIVATE)
    }
}