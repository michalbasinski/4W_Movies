package org.w4.api.movies.domain

import org.springframework.stereotype.Component

@Component
class MovieFacade internal constructor(
    private val moviesRepository: MoviesRepository,
    private val movieDetailsFetcher: MovieDetailsFetcher
) {
    internal fun getAllMovies() = moviesRepository.findAll()
    internal fun getMovie(id: Long) = movieDetailsFetcher.getMovieDetails(id)

    internal fun rateMovie(id: Long, rating: Float) = moviesRepository.findById(id)
        .map {
            Movie(it.id,
                it.name,
                it.extId,
                it.ratings.toMutableList().let { ratings ->
                    ratings.add(rating)
                    ratings.toList()
                })
        }
        .also { moviesRepository.save(it.get()) }

}