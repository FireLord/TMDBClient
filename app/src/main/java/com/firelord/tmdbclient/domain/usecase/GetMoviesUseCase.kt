package com.firelord.tmdbclient.domain.usecase

import com.firelord.tmdbclient.data.model.movie.Movie
import com.firelord.tmdbclient.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.getMovies()

}