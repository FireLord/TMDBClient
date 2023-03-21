package com.firelord.tmdbclient.presentation.di.movie

import com.firelord.tmdbclient.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    /*
    We must define a subcomponent factory inside this ArtistComponent
    so that AppComponent knows how to create instances of this
    ArtistComponent sub component. This is how we do it.
    */
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }
}