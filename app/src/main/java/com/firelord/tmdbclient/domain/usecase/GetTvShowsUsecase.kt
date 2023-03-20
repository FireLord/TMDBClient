package com.firelord.tmdbclient.domain.usecase

import com.firelord.tmdbclient.data.model.tvShow.TvShow
import com.firelord.tmdbclient.domain.repository.TvShowRepository

class GetTvShowsUsecase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>? = tvShowRepository.getTvShows()
}