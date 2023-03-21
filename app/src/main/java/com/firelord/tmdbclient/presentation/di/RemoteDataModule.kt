package com.firelord.tmdbclient.presentation.di

import com.firelord.tmdbclient.data.api.TMDBService
import com.firelord.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.firelord.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDatasourceImpl
import com.firelord.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.firelord.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.firelord.tmdbclient.data.repository.tvShow.datasource.TvShowRemoteDatasource
import com.firelord.tmdbclient.data.repository.tvShow.datasourceImpl.TvShowRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey:String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService):MovieRemoteDatasource{
        return MovieRemoteDataSourceImpl(tmdbService,apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService):TvShowRemoteDatasource{
        return TvShowRemoteDatasourceImpl(tmdbService,apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService):ArtistRemoteDatasource{
        return ArtistRemoteDatasourceImpl(tmdbService,apiKey)
    }
}