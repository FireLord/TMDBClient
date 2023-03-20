package com.firelord.tmdbclient.domain.repository

import com.firelord.tmdbclient.data.model.tvShow.TvShow

interface TvShowRepository {
    suspend fun getTvShows():List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?
}