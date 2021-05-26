package org.w4.api.screenings.dtos

import java.time.LocalDateTime

data class NewScreeningDto(val movieId: Long, val date: LocalDateTime, val price: String)