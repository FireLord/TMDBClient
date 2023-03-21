package com.firelord.tmdbclient.data.repository.artist

import android.util.Log
import com.firelord.tmdbclient.data.model.artist.Artist
import com.firelord.tmdbclient.data.repository.artist.datasource.ArtistCacheDatasource
import com.firelord.tmdbclient.data.repository.artist.datasource.ArtistLocalDatasource
import com.firelord.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.firelord.tmdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistLocalDatasource: ArtistLocalDatasource,
    private val artistCacheDatasource: ArtistCacheDatasource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtist = getArtistsFromAPI()
        artistLocalDatasource.clearAll()
        artistLocalDatasource.saveArtistsToDB(newListOfArtist)
        artistCacheDatasource.saveArtistsToCache(newListOfArtist)
        return newListOfArtist
    }

    suspend fun getArtistsFromAPI():List<Artist>{
        lateinit var artistList:List<Artist>
        try {
            val response = artistRemoteDatasource.getArtists()
            val body = response.body()
            if (body!=null){
                artistList = body.artists
            }
        }catch (exception:Exception){
            Log.i("Mytag",exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistsFromDB():List<Artist>{
        lateinit var artistList:List<Artist>
        try {
            artistList = artistLocalDatasource.getArtistsFromDB()
        }catch (exception:Exception){
            Log.i("Mytag",exception.message.toString())
        }
        if (artistList.size>0){
            return artistList
        }else{
            artistList=getArtistsFromAPI()
            artistLocalDatasource.saveArtistsToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistsFromCache():List<Artist>{
        lateinit var artistList:List<Artist>
        try {
            artistList = artistCacheDatasource.getArtistsFromCache()
        }catch (exception:Exception){
            Log.i("Mytag",exception.message.toString())
        }
        if (artistList.size>0){
            return artistList
        }else{
            artistList=getArtistsFromDB()
            artistCacheDatasource.saveArtistsToCache(artistList)
        }
        return artistList
    }
}