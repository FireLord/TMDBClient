package com.firelord.tmdbclient.domain.usecase

import com.firelord.tmdbclient.data.model.tvShow.TvShow
import com.firelord.tmdbclient.domain.repository.TvShowRepository

class UpdateTvShowsUsecase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>? = tvShowRepository.updateTvShows()
}