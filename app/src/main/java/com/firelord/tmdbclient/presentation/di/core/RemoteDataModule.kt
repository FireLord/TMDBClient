package com.firelord.tmdbclient.presentation.di.core

import com.firelord.tmdbclient.BuildConfig
import com.firelord.tmdbclient.data.api.TMDBService
import com.firelord.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.firelord.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDatasourceImpl
import com.firelord.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.firelord.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.firelord.tmdbclient.data.repository.tvShow.datasource.TvShowRemoteDatasource
import com.firelord.tmdbclient.data.repository.tvShow.datasourceImpl.TvShowRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule() {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService):MovieRemoteDatasource{
        return MovieRemoteDataSourceImpl(tmdbService,BuildConfig.API_KEY)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService):TvShowRemoteDatasource{
        return TvShowRemoteDatasourceImpl(tmdbService, BuildConfig.API_KEY)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService):ArtistRemoteDatasource{
        return ArtistRemoteDatasourceImpl(tmdbService,BuildConfig.API_KEY)
    }
}