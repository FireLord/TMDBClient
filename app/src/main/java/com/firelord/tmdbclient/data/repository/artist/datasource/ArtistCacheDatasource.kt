package com.firelord.tmdbclient.data.repository.artist.datasource

import com.firelord.tmdbclient.data.model.artist.Artist

interface ArtistCacheDatasource {
    suspend fun getArtistsFromCache():List<Artist>
    suspend fun saveArtistsToCache(artist: List<Artist>)
}