package ru.blackmirrror.moviesapp.data.repository

import ru.blackmirrror.moviesapp.data.api.ApiService
import ru.blackmirrror.moviesapp.data.api.NetworkState
import ru.blackmirrror.moviesapp.domain.models.MoviesListResponse
import ru.blackmirrror.moviesapp.domain.repository.MoviesRepository

class MoviesRepositoryImpl(private val apiService: ApiService): MoviesRepository {

    override suspend fun getAllMovies(): MoviesListResponse? {
        val response = apiService.getAllMovies()
        return if (response.isSuccessful)
            response.body()
        else
            null
    }
}