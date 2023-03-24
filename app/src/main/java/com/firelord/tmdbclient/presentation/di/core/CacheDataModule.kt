package com.firelord.tmdbclient.presentation.di.core

import com.firelord.tmdbclient.data.repository.artist.datasource.ArtistCacheDatasource
import com.firelord.tmdbclient.data.repository.artist.datasourceImpl.ArtistCacheDatasourceImpl
import com.firelord.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource
import com.firelord.tmdbclient.data.repository.movie.datasourceImpl.MovieCacheDatasourceImpl
import com.firelord.tmdbclient.data.repository.tvShow.datasource.TvShowCacheDatasource
import com.firelord.tmdbclient.data.repository.tvShow.datasourceImpl.TvShowCacheDatasourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource():MovieCacheDatasource{
        return MovieCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource():TvShowCacheDatasource{
        return TvShowCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun provideMovieArtistDataSource():ArtistCacheDatasource{
        return ArtistCacheDatasourceImpl()
    }

}