package com.firelord.tmdbclient.data.repository.tvShow.datasourceImpl

import com.firelord.tmdbclient.data.db.TvShowDao
import com.firelord.tmdbclient.data.model.tvShow.TvShow
import com.firelord.tmdbclient.data.repository.tvShow.datasource.TvShowLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDatasourceImpl(
    private val tvShowDao: TvShowDao
) : TvShowLocalDatasource{
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}