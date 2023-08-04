package ru.blackmirrror.moviesapp.domain.usecases

import ru.blackmirrror.moviesapp.domain.models.MovieResponse
import ru.blackmirrror.moviesapp.domain.models.MoviesListResponse
import ru.blackmirrror.moviesapp.domain.repository.MoviesRepository

class GetAllMoviesUseCase(private val moviesRepository: MoviesRepository) {
    suspend fun execute(): MoviesListResponse? {
        return moviesRepository.getAllMovies()
    }
}