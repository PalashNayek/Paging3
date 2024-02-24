package com.palash.paging3.di

import android.content.Context
import androidx.room.Room
import com.palash.paging3.db.QuoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule  {

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context : Context) : QuoteDatabase{
        return Room.databaseBuilder(context, QuoteDatabase::class.java, "quoteDB").build()
    }
}