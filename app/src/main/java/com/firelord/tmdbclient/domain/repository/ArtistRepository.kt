package com.firelord.tmdbclient.domain.repository

import com.firelord.tmdbclient.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists():List<Artist>?
}