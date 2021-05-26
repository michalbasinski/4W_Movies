package org.w4.api.movies.domain

import org.springframework.stereotype.Component

@Component
class MovieFacade internal constructor(
    private val moviesRepository: MoviesRepository,
    private val movieDetailsFetcher: MovieDetailsFetcher
) {
    internal fun getAllMovies() = moviesRepository.findAll()
    internal fun getMovie(id: Long) = movieDetailsFetcher.getMovieDetails(id)

    internal fun rateMovie(id: Long, rating: Float) = moviesRepository.findById(id).map { movie ->
        movie.ratings.add(rating)
        movie
    }.let { updatedMovie -> moviesRepository.save(updatedMovie.get()) }

}