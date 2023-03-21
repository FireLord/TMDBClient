package com.firelord.tmdbclient.presentation.di.tvShow

import com.firelord.tmdbclient.domain.usecase.GetTvShowsUsecase
import com.firelord.tmdbclient.domain.usecase.UpdateTvShowsUsecase
import com.firelord.tmdbclient.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUsecase: GetTvShowsUsecase,
        updateTvShowsUsecase: UpdateTvShowsUsecase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowsUsecase,
            updateTvShowsUsecase
        )
    }
}