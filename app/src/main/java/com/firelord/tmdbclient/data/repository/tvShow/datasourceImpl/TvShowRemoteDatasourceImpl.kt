package com.firelord.tmdbclient.data.repository.tvShow.datasourceImpl

import com.firelord.tmdbclient.data.api.TMDBService
import com.firelord.tmdbclient.data.model.tvShow.TvShowList
import com.firelord.tmdbclient.data.repository.tvShow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
) : TvShowRemoteDatasource{
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)
}