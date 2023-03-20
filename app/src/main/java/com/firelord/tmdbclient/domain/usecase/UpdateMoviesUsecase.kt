package com.firelord.tmdbclient.domain.usecase

import com.firelord.tmdbclient.data.model.movie.Movie
import com.firelord.tmdbclient.domain.repository.MovieRepository

class UpdateMoviesUsecase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}