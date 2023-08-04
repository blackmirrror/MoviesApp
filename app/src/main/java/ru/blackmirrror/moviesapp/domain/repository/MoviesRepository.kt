package ru.blackmirrror.moviesapp.domain.repository

import ru.blackmirrror.moviesapp.data.api.NetworkState
import ru.blackmirrror.moviesapp.domain.models.MovieResponse
import ru.blackmirrror.moviesapp.domain.models.MoviesListResponse

interface MoviesRepository {
    suspend fun getAllMovies(): MoviesListResponse?
}