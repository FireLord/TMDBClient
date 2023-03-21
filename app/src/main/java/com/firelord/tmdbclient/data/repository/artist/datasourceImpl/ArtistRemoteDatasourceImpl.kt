package com.firelord.tmdbclient.data.repository.artist.datasourceImpl

import com.firelord.tmdbclient.data.api.TMDBService
import com.firelord.tmdbclient.data.model.artist.ArtistList
import com.firelord.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
) : ArtistRemoteDatasource{
    override suspend fun getArtists(): Response<ArtistList> = tmdbService.getPopularArtist(apiKey)
}