package com.firelord.tmdbclient.presentation.di.artist

import com.firelord.tmdbclient.domain.usecase.GetArtistsUsecase
import com.firelord.tmdbclient.domain.usecase.UpdateArtistUsecase
import com.firelord.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class ArtistModule {
    @ActivityScoped
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