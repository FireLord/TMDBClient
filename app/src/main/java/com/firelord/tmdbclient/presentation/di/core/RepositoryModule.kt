package com.firelord.tmdbclient.presentation.di.core

import com.firelord.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.firelord.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource
import com.firelord.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.firelord.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.firelord.tmdbclient.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDatasource: MovieLocalDatasource,
        movieCacheDatasource: MovieCacheDatasource
    ): MovieRepository{
        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDatasource,
            movieCacheDatasource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDatasource: MovieLocalDatasource,
        movieCacheDatasource: MovieCacheDatasource
    ): MovieRepository{
        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDatasource,
            movieCacheDatasource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDatasource: MovieLocalDatasource,
        movieCacheDatasource: MovieCacheDatasource
    ): MovieRepository{
        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDatasource,
            movieCacheDatasource
        )
    }
}