package com.firelord.tmdbclient.presentation.di

import com.firelord.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.firelord.tmdbclient.presentation.di.movie.MovieSubComponent
import com.firelord.tmdbclient.presentation.di.tvShow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent():MovieSubComponent
    fun createTvShowSubComponent():TvShowSubComponent
    fun createArtistSubComponent():ArtistSubComponent
}