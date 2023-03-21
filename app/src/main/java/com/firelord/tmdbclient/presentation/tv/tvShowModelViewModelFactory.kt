package com.firelord.tmdbclient.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.firelord.tmdbclient.domain.usecase.GetTvShowsUsecase
import com.firelord.tmdbclient.domain.usecase.UpdateTvShowsUsecase

class tvShowModelViewModelFactory(
    private val getTvShowsUsecase: GetTvShowsUsecase,
    private val updateTvShowsUsecase: UpdateTvShowsUsecase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowsUsecase,updateTvShowsUsecase) as T
    }
}