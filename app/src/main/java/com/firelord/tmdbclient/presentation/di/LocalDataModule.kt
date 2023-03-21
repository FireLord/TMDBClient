package com.firelord.tmdbclient.presentation.di

import com.firelord.tmdbclient.data.db.ArtistDao
import com.firelord.tmdbclient.data.db.MovieDao
import com.firelord.tmdbclient.data.db.TvShowDao
import com.firelord.tmdbclient.data.repository.artist.datasource.ArtistLocalDatasource
import com.firelord.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDatabaseImpl
import com.firelord.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.firelord.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDatabaseSourceImpl
import com.firelord.tmdbclient.data.repository.tvShow.datasource.TvShowLocalDatasource
import com.firelord.tmdbclient.data.repository.tvShow.datasourceImpl.TvShowLocalDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
     /*
     Now, in this module we are going to construct and return this
     MovieLocalDataSourceImpl,TvShowLocalDataSourceImpl and
     ArtistLocalDataSourceImpl instances. You can see, they all have
     their dao interface as a constructor parameter. So when we create
     provider function, we need to add those dao interfaces as function
     parameters. We have already created this database module to provide
     those dao dependencies.
    */

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDatasource{
        return MovieLocalDatabaseSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao):TvShowLocalDatasource{
        return TvShowLocalDatasourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao):ArtistLocalDatasource{
        return ArtistLocalDatabaseImpl(artistDao)
    }

}