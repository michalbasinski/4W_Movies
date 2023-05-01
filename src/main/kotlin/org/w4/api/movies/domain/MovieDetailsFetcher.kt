package org.w4.api.movies.domain

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import org.w4.api.movies.dto.MovieDetailsDto
import java.util.*

@Component
internal class MovieDetailsFetcher(
    private val repository: MoviesRepository,
    private val restTemplate: RestTemplate
) {

    @Value("\${provider.api.key}")
    lateinit var apiKey: String

    @Value("\${provider.api.url}")
    lateinit var providerUrl: String

    fun getMovieDetails(id: Long): MovieDetailsDto =
        repository.findById(id)
            .map { movie -> movie.extId }
            .orElseThrow().let { extId ->
                getMovieDetailsFromService(providerUrl, apiKey, extId)
                    .let { movieDetails ->
                        Optional.ofNullable(movieDetails)
                            .map { it.toDto() }
                            .orElseThrow { RuntimeException() }
                    }
            }

    private fun getMovieDetailsFromService(providerUrl: String, apiKey: String, extId: String) =
        restTemplate.getForEntity(
            UriComponentsBuilder.fromHttpUrl(providerUrl)
                .queryParam("apiKey", apiKey)
                .queryParam("i", extId)
                .toUriString(), ProviderResponse::class.java
        ).body
}
