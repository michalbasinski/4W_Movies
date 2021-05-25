package org.w4.api.movies.domain

import org.springframework.stereotype.Component

@Component
class MovieFacade internal constructor(
    private val moviesRepository: MoviesRepository,
    private val movieDetailsFetcher: MovieDetailsFetcher
) {
    internal fun getAllMovies() = moviesRepository.findAll()
    internal fun getMovie(id: Long) = movieDetailsFetcher.getMovieDetails(id)
}