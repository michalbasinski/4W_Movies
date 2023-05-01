package org.w4.api.screenings.domain

import org.springframework.stereotype.Component
import org.w4.api.movies.domain.MovieFacade
import org.w4.api.screenings.dtos.NewScreeningDto
import org.w4.api.screenings.dtos.ScreeningDto
import java.time.LocalDateTime

@Component
class ScreeningFacade(
    private val repository: ScreeningRepository,
    private val facade: MovieFacade
) {
    fun getShowsForMovie(movieId: Long) =
        facade.getMovie(movieId)
            .let { movie ->
                repository.findAllByMovieId(movieId).map {
                    ScreeningDto(
                        title = movie.title,
                        date = it.date,
                        price = it.price,
                        movieId = it.movieId
                    )
                }
            }

    fun searchShowsByDate(start: LocalDateTime, end: LocalDateTime) =
        repository.findScreeningsByDate(start, end).map {
            ScreeningDto(
                title = facade.getMovie(it.movieId).title,
                date = it.date,
                price = it.price,
                movieId = it.movieId
            )
        }

    fun addScreening(screening: NewScreeningDto) = repository.save(screening.toDBModel()).let {
        ScreeningDto(
            title = facade.getMovie(it.movieId).title,
            date = it.date,
            price = it.price,
            movieId = it.movieId
        )
    }

    fun NewScreeningDto.toDBModel() = Screening(
        id = null,
        movieId = this.movieId,
        date = this.date,
        price = this.price
    )
}