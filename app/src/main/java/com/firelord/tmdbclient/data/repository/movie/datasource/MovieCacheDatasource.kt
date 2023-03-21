package com.firelord.tmdbclient.data.repository.movie.datasource

import com.firelord.tmdbclient.data.model.movie.Movie

interface MovieCacheDatasource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movie:List<Movie>)
}