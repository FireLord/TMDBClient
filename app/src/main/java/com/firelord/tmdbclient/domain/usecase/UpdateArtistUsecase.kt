package com.firelord.tmdbclient.domain.usecase

import com.firelord.tmdbclient.data.model.artist.Artist
import com.firelord.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistUsecase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.updateArtists()
}