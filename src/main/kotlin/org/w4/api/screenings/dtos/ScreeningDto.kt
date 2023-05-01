package org.w4.api.screenings.dtos

import java.time.LocalDateTime

class ScreeningDto(
    val title: String = "N/A",
    val date: LocalDateTime = LocalDateTime.MIN,
    val price: String = "0",
    val movieId: Long = Long.MIN_VALUE
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ScreeningDto

        if (title != other.title) return false
        if (date != other.date) return false
        if (price != other.price) return false
        if (movieId != other.movieId) return false

        return true
    }
}