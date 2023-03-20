package com.firelord.tmdbclient.data


import com.firelord.tmdbclient.data.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)