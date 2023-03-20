package com.firelord.tmdbclient.data


import com.firelord.tmdbclient.data.TvShow
import com.google.gson.annotations.SerializedName

data class TvShowList(
    @SerializedName("results")
    val tvShows: List<TvShow>,
)