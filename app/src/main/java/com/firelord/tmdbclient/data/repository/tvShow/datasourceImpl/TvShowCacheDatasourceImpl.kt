package com.firelord.tmdbclient.data.repository.tvShow.datasourceImpl

import com.firelord.tmdbclient.data.model.tvShow.TvShow
import com.firelord.tmdbclient.data.repository.tvShow.datasource.TvShowCacheDatasource

class TvShowCacheDatasourceImpl: TvShowCacheDatasource {
    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsFromCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}