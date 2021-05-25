package org.w4.api.movies.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import org.w4.api.movies.dto.MovieDetailsDto

@JsonIgnoreProperties(ignoreUnknown = true)
class ProviderResponse {
    @JsonProperty("Title")
    var title: String? = null
    @JsonProperty("imdbRating")
    var imdbRating: Float? = null
    @JsonProperty("Runtime")
    var runtime: String? = null

    fun toDto() = MovieDetailsDto(title, imdbRating, runtime)
}
