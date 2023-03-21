package com.firelord.tmdbclient.data.repository.movie.datasourceImpl

import com.firelord.tmdbclient.data.db.MovieDao
import com.firelord.tmdbclient.data.model.movie.Movie
import com.firelord.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDatabaseSourceImpl(
    private val movieDao:MovieDao
) : MovieLocalDatasource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDao.getMovies()
    }

    /*
    When we are getting data from the room database, room execute that
    query in a back ground thread. So we don’t need to explicitly write
    codes for background processing. But, we need to invoke other dao
    functions from a background thread. We will use coroutines for that.
    */
    override suspend fun saveMoviesToDB(movies : List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}