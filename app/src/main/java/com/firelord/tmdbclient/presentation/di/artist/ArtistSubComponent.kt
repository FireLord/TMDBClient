package com.firelord.tmdbclient.presentation.di.artist

import com.firelord.tmdbclient.presentation.artist.ArtistActivity
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    /*
    We must define a subcomponent factory inside this ArtistComponent
    so that AppComponent knows how to create instances of this
    ArtistComponent sub component. This is how we do it.
    */
    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():ArtistSubComponent
    }
}