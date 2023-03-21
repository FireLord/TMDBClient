package com.firelord.tmdbclient.data.repository.movie.datasource

import com.firelord.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies(): Response<MovieList> // get from retrofit response
}