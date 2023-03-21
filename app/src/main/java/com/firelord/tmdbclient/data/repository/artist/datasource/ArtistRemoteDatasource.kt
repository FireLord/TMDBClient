package com.firelord.tmdbclient.data.repository.artist.datasource

import com.firelord.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {
    suspend fun getArtists(): Response<ArtistList>
}