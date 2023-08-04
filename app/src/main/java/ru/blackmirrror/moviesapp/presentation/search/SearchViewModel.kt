package ru.blackmirrror.moviesapp.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import ru.blackmirrror.moviesapp.data.api.NetworkState
import ru.blackmirrror.moviesapp.domain.models.MovieResponse
import ru.blackmirrror.moviesapp.domain.repository.MoviesRepository

class SearchViewModel(private val moviesRepository: MoviesRepository): ViewModel() {

    private val _movies = MutableSharedFlow<List<MovieResponse>>()
    val movies = _movies.asSharedFlow()

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = moviesRepository.getAllMovies()
            response?.items?.let { _movies.emit(it) }
        }
    }
}