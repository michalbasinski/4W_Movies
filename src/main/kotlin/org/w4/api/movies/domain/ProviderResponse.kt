package org.w4.api.movies.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import org.w4.api.movies.dto.MovieDetailsDto
import java.math.BigDecimal

@JsonIgnoreProperties(ignoreUnknown = true)
data class ProviderResponse(
    @JsonProperty("Title")
    val title: String,
    @JsonProperty("imdbRating")
    val imdbRating: BigDecimal,
    @JsonProperty("Runtime")
    val runtime: String
) {
    fun toDto() = MovieDetailsDto(title, imdbRating.toFloat(), runtime)
}
