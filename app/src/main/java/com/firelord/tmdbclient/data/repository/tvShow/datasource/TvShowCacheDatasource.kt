package com.firelord.tmdbclient.data.repository.tvShow.datasource

import com.firelord.tmdbclient.data.model.tvShow.TvShow

interface TvShowCacheDatasource {
    suspend fun getTvShowsFromCache():List<TvShow>
    suspend fun saveTvShowsFromCache(tvShows: List<TvShow>)
}