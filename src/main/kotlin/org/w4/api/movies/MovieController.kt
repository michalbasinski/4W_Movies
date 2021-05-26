package org.w4.api.movies

import org.springframework.web.bind.annotation.*
import org.w4.api.movies.domain.MovieFacade
import org.w4.api.movies.dto.MovieDto
import org.w4.api.movies.dto.MovieRatingDto

@RestController
internal class MovieController(private val facade: MovieFacade) {

    @GetMapping("/movies")
    fun getMovies(): List<MovieDto> = facade.getAllMovies().map { it.toDto() }

    @GetMapping("movies/{id}")
    fun getMovieById(@PathVariable id: Long) = facade.getMovie(id)

    @PostMapping("/movies/{id}")
    fun rateMovie(@PathVariable id: Long, @RequestBody rating: MovieRatingDto) = facade.rateMovie(id, rating.rating ?: 0.toFloat())
}