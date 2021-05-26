package org.w4.api.screenings

import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.*
import org.w4.api.screenings.domain.ScreeningFacade
import org.w4.api.screenings.dtos.NewScreeningDto
import java.time.LocalDateTime

@RestController
class ScreeningsController(private val facade: ScreeningFacade) {

    @GetMapping("/screenings/{movieId}")
    fun getScreeningsForMovie(@PathVariable movieId: Long) = facade.getShowsForMovie(movieId)

    @GetMapping("/screenings")
    fun getScreeningsByDate(
        @RequestParam(required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) from: LocalDateTime,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) to: LocalDateTime?
    ) =
        facade.searchShowsByDate(from, to ?: LocalDateTime.now().plusDays(7))

    @PostMapping("/internal/screenings")
    fun addNewScreening(@RequestBody screening: NewScreeningDto) = facade.addScreening(screening)
}