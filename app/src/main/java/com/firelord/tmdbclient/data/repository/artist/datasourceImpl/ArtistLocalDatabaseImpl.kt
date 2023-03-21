package com.firelord.tmdbclient.data.repository.artist.datasourceImpl

import com.firelord.tmdbclient.data.db.ArtistDao
import com.firelord.tmdbclient.data.model.artist.Artist
import com.firelord.tmdbclient.data.repository.artist.datasource.ArtistLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDatabaseImpl(
    private val artistDao: ArtistDao
): ArtistLocalDatasource {
    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch{
            artistDao.saveArtist(artists)
        }
    }

    override suspend fun clearAll() {
        artistDao.deleteAllArtist()
    }
}