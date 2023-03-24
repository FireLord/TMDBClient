package com.firelord.tmdbclient.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.firelord.tmdbclient.data.model.movie.Movie
import com.firelord.tmdbclient.data.repository.movie.FakeMovieRepository
import com.firelord.tmdbclient.domain.usecase.GetMoviesUseCase
import com.firelord.tmdbclient.domain.usecase.UpdateMoviesUsecase
import com.firelord.tmdbclient.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        val fakeMovieViewModel = FakeMovieRepository()
        val getMoviesUseCase = GetMoviesUseCase(fakeMovieViewModel)
        val updateMoviesUsecase = UpdateMoviesUsecase(fakeMovieViewModel)
        viewModel = MovieViewModel(getMoviesUseCase,updateMoviesUsecase)
    }

    @Test
    fun getMovies_returnCurrentList() {
        val movies = mutableListOf<Movie>()
        movies.add(Movie(1, "overview1", "path1", "date1", "title1"))
        movies.add(Movie(2, "overview2", "path2", "date2", "title2"))

        val currentList = viewModel.getMovies().getOrAwaitValue()
        assertThat(currentList).isEqualTo(movies)
    }

    @Test
    fun updateMovies_returnUpdatedList() {
        val movies = mutableListOf<Movie>()
        movies.add(Movie(3,"overview3","path3","date3","title3"))
        movies.add(Movie(4,"overview4","path4","date4","title4"))

        val updatedList = viewModel.updateMovies().getOrAwaitValue()
        assertThat(updatedList).isEqualTo(movies)
    }
}