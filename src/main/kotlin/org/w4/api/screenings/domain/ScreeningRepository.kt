package org.w4.api.screenings.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.time.LocalDateTime

interface ScreeningRepository : JpaRepository<Screening, Long> {
    fun findAllByMovieId(movieId: Long): List<Screening>

    @Query("FROM Screening AS u WHERE u.date BETWEEN ?1 AND ?2")
    fun findScreeningsByDate(start: LocalDateTime, end: LocalDateTime): List<Screening>
}
