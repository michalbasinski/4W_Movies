package org.w4.api.screenings.dtos

import java.time.LocalDateTime

class ScreeningDto() {
    var title: String? = null
    var date: LocalDateTime? = null
    var price: String? = null
    var movieId: Long? = null

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