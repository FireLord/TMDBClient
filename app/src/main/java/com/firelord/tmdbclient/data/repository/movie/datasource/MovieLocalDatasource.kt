package com.firelord.tmdbclient.data.repository.movie.datasource

import com.firelord.tmdbclient.data.model.movie.Movie

interface MovieLocalDatasource {
    suspend fun getMoviesFromDB():List<Movie> // it will get from db
    suspend fun saveMoviesToDB(movies: List<Movie>) // it will save in db
    suspend fun clearAll()
}