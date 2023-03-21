package com.firelord.tmdbclient.presentation.di.core

import com.firelord.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import com.firelord.tmdbclient.data.repository.artist.datasource.ArtistCacheDatasource
import com.firelord.tmdbclient.data.repository.artist.datasource.ArtistLocalDatasource
import com.firelord.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.firelord.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.firelord.tmdbclient.data.repository.movie.datasource.MovieCacheDatasource
import com.firelord.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.firelord.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.firelord.tmdbclient.data.repository.tvShow.TvShowRepositoryImpl
import com.firelord.tmdbclient.data.repository.tvShow.datasource.TvShowCacheDatasource
import com.firelord.tmdbclient.data.repository.tvShow.datasource.TvShowLocalDatasource
import com.firelord.tmdbclient.data.repository.tvShow.datasource.TvShowRemoteDatasource
import com.firelord.tmdbclient.domain.repository.ArtistRepository
import com.firelord.tmdbclient.domain.repository.MovieRepository
import com.firelord.tmdbclient.domain.repository.TvShowRepository
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
        tvShowRemoteDatasource: TvShowRemoteDatasource,
        tvShowLocalDatasource: TvShowLocalDatasource,
        tvShowCacheDatasource: TvShowCacheDatasource
    ): TvShowRepository{
        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDatasource,
            tvShowCacheDatasource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistShowRemoteDatasource: ArtistRemoteDatasource,
        artistLocalDatasource: ArtistLocalDatasource,
        artistCacheDatasource: ArtistCacheDatasource
    ): ArtistRepository{
        return ArtistRepositoryImpl(
            artistShowRemoteDatasource,
            artistLocalDatasource,
            artistCacheDatasource
        )
    }
}