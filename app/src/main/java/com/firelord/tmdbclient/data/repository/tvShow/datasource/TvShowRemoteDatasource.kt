package com.firelord.tmdbclient.data.repository.tvShow.datasource

import com.firelord.tmdbclient.data.model.tvShow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {
    suspend fun getTvShows():Response<TvShowList>
}