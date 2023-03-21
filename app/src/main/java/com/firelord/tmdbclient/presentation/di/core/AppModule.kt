package com.firelord.tmdbclient.presentation.di.core

import android.content.Context
import com.firelord.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.firelord.tmdbclient.presentation.di.movie.MovieSubComponent
import com.firelord.tmdbclient.presentation.di.tvShow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [
MovieSubComponent::class,
TvShowSubComponent::class,
ArtistSubComponent::class
])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }
}