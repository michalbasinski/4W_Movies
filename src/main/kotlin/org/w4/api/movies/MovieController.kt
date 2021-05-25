package org.w4.api.movies

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.w4.api.movies.domain.MovieFacade
import org.w4.api.movies.dto.MovieDto

@RestController
internal class MovieController(private val facade: MovieFacade) {

    @GetMapping("/movies")
    fun getMovies(): List<MovieDto> = facade.getAllMovies().map { it.toDto() }

    @GetMapping("movies/{id}")
    fun getMovieById(@PathVariable id : Long) = facade.getMovie(id)
}