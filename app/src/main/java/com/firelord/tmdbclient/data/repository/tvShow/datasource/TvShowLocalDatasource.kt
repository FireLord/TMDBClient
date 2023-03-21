package com.firelord.tmdbclient.data.repository.tvShow.datasource

import com.firelord.tmdbclient.data.model.tvShow.TvShow

interface TvShowLocalDatasource {
    suspend fun getTvShowsFromDB():List<TvShow>
    suspend fun saveTvShowsToDB(tvShows: List<TvShow>)
    suspend fun clearAll()
}