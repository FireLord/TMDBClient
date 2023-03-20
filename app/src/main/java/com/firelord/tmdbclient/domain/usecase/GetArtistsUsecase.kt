package com.firelord.tmdbclient.domain.usecase

import com.firelord.tmdbclient.data.model.artist.Artist
import com.firelord.tmdbclient.domain.repository.ArtistRepository

class GetArtistsUsecase(private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.getArtists()
}