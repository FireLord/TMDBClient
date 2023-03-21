package com.firelord.tmdbclient.presentation.di.artist

import com.firelord.tmdbclient.domain.usecase.GetArtistsUsecase
import com.firelord.tmdbclient.domain.usecase.UpdateArtistUsecase
import com.firelord.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUsecase: GetArtistsUsecase,
        updateArtistUsecase: UpdateArtistUsecase
    ):ArtistViewModelFactory{
        return ArtistViewModelFactory(
            getArtistsUsecase,
            updateArtistUsecase
        )
    }
}