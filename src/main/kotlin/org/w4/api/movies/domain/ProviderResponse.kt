package org.w4.api.movies.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import org.w4.api.movies.dto.MovieDetailsDto
import java.math.BigDecimal

@JsonIgnoreProperties(ignoreUnknown = true)
class ProviderResponse {
    @JsonProperty("Title")
    lateinit var title: String
    @JsonProperty("imdbRating")
    lateinit var imdbRating: BigDecimal
    @JsonProperty("Runtime")
    lateinit var runtime: String

    fun toDto() = MovieDetailsDto(title, imdbRating.toFloat(), runtime)
}
