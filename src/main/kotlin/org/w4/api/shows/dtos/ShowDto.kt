package org.w4.api.shows.dtos

import java.time.LocalDateTime

data class ShowDto(val title: String, val data: LocalDateTime, val price: Long, val currencyCode: String)