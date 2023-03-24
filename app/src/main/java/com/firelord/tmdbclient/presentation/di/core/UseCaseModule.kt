package com.firelord.tmdbclient.presentation.di.core

import com.firelord.tmdbclient.domain.repository.ArtistRepository
import com.firelord.tmdbclient.domain.repository.MovieRepository
import com.firelord.tmdbclient.domain.repository.TvShowRepository
import com.firelord.tmdbclient.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository):GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository):UpdateMoviesUsecase{
        return UpdateMoviesUsecase(movieRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository):GetTvShowsUsecase{
        return GetTvShowsUsecase(tvShowRepository)
    }
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository):UpdateTvShowsUsecase{
        return UpdateTvShowsUsecase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository):GetArtistsUsecase{
        return GetArtistsUsecase(artistRepository)
    }
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository):UpdateArtistUsecase{
        return UpdateArtistUsecase(artistRepository)
    }
}