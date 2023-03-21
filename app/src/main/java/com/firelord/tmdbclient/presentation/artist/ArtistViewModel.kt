package com.firelord.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.firelord.tmdbclient.domain.usecase.GetArtistsUsecase
import com.firelord.tmdbclient.domain.usecase.UpdateArtistUsecase

class ArtistViewModel(
    private val getArtistsUsecase: GetArtistsUsecase,
    private val updateArtistUsecase: UpdateArtistUsecase
): ViewModel() {
    fun getArtists() = liveData {
        val artistList = getArtistsUsecase.execute()
        emit(artistList)
    }

    fun updateArists() = liveData {
        val artistList = updateArtistUsecase.execute()
        emit(artistList)
    }
}