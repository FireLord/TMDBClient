package com.firelord.tmdbclient.data.model.tvShow


import com.firelord.tmdbclient.data.model.tvShow.TvShow
import com.google.gson.annotations.SerializedName

data class TvShowList(
    @SerializedName("results")
    val tvShows: List<TvShow>,
)