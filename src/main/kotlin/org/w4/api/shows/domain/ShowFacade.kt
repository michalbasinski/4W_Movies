package org.w4.api.shows.domain

import org.w4.api.shows.dtos.ShowDto
import java.time.LocalDateTime

class ShowFacade {
    fun getShowsForMovie(id:Long) = listOf<ShowDto>()
    fun searchShowsByDate(start:LocalDateTime, end:LocalDateTime) = listOf<ShowDto>()
}