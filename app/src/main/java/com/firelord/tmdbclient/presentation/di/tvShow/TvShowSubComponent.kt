package com.firelord.tmdbclient.presentation.di.tvShow

import com.firelord.tmdbclient.presentation.tv.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    /*
    We must define a subcomponent factory inside this ArtistComponent
    so that AppComponent knows how to create instances of this
    ArtistComponent sub component. This is how we do it.
    */
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): TvShowSubComponent
    }
}