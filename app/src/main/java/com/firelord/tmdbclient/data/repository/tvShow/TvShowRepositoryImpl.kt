package com.firelord.tmdbclient.data.repository.tvShow

import android.util.Log
import com.firelord.tmdbclient.data.model.tvShow.TvShow
import com.firelord.tmdbclient.data.repository.tvShow.datasource.TvShowCacheDatasource
import com.firelord.tmdbclient.data.repository.tvShow.datasource.TvShowLocalDatasource
import com.firelord.tmdbclient.data.repository.tvShow.datasource.TvShowRemoteDatasource
import com.firelord.tmdbclient.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDatasource: TvShowRemoteDatasource,
    private val tvShowLocalDatasource: TvShowLocalDatasource,
    private val tvShowCacheDatasource: TvShowCacheDatasource
) : TvShowRepository{
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShow = getTvShowsFromAPI()
        tvShowLocalDatasource.clearAll()
        tvShowLocalDatasource.saveTvShowsToDB(newListOfTvShow)
        tvShowCacheDatasource.saveTvShowsFromCache(newListOfTvShow)
        return newListOfTvShow
    }

    suspend fun getTvShowsFromAPI():List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try{
            val response = tvShowRemoteDatasource.getTvShows()
            val body = response.body()
            if (body!=null){
                tvShowList = body.tvShows
            }
        }catch (exception:Exception){
            Log.i("Mytag",exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowsFromDB():List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try {
            tvShowList=tvShowLocalDatasource.getTvShowsFromDB()
        }catch (exception:Exception){
            Log.i("Mytag",exception.message.toString())
        }
        if (tvShowList.size>0){
            return tvShowList
        }else{
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDatasource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowsFromCache():List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try {
            tvShowList=tvShowCacheDatasource.getTvShowsFromCache()
        }catch (exception:Exception){
            Log.i("Mytag",exception.message.toString())
        }
        if (tvShowList.size>0){
            return tvShowList
        }else{
            tvShowList = getTvShowsFromDB()
            tvShowCacheDatasource.saveTvShowsFromCache(tvShowList)
        }
        return tvShowList
    }
}