package ru.blackmirrror.moviesapp.data.api

import retrofit2.Response
import retrofit2.http.GET
import ru.blackmirrror.moviesapp.domain.models.MoviesListResponse

interface ApiService {

    @GET("films")
    suspend fun getAllMovies(): Response<MoviesListResponse>
}