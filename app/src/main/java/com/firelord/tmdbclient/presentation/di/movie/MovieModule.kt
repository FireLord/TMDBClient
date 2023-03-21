package com.firelord.tmdbclient.presentation.di.movie

import com.firelord.tmdbclient.domain.usecase.GetMoviesUseCase
import com.firelord.tmdbclient.domain.usecase.UpdateMoviesUsecase
import com.firelord.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUsecase: UpdateMoviesUsecase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUsecase
        )
    }
}