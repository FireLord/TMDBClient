package com.firelord.tmdbclient.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.firelord.tmdbclient.domain.usecase.GetTvShowsUsecase
import com.firelord.tmdbclient.domain.usecase.UpdateTvShowsUsecase

class TvShowViewModel(
    private val getTvShowsUsecase: GetTvShowsUsecase,
    private val updateTvShowsUsecase: UpdateTvShowsUsecase
): ViewModel(){
    fun getTvShows() = liveData {
        val tvShowList = getTvShowsUsecase.execute()
        emit(tvShowList)
    }

    fun updateTvShows() = liveData {
        val tvShowList = updateTvShowsUsecase.execute()
        emit(tvShowList)
    }
}