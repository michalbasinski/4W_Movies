package org.w4.api.screenings.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "screenings")
data class Screening(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val movieId: Long,
    val date: LocalDateTime,
    val price: String
)