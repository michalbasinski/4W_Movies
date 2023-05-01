package org.w4.api.movies.dto

data class MovieDetailsDto(
    val title: String = "N/A",
    val imdbScore: Float = 0F,
    val runtime: String = "N/A"
)