package com.firelord.tmdbclient.data.model.movie


import com.firelord.tmdbclient.data.model.movie.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)