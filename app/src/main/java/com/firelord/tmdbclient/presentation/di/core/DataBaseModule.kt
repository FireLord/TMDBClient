package com.firelord.tmdbclient.presentation.di.core

import android.app.Application
import androidx.room.Room
import com.firelord.tmdbclient.data.db.ArtistDao
import com.firelord.tmdbclient.data.db.MovieDao
import com.firelord.tmdbclient.data.db.TMDBDatabase
import com.firelord.tmdbclient.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideMovieDataBase(app: Application):TMDBDatabase{
        return Room.databaseBuilder(app,TMDBDatabase::class.java,"tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase):MovieDao{
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvDao(tmdbDatabase: TMDBDatabase):TvShowDao{
        return tmdbDatabase.tvDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase):ArtistDao{
        return tmdbDatabase.artistDao()
    }
}