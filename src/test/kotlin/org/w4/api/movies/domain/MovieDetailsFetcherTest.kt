package org.w4.api.movies.domain

import io.mockk.every
import io.mockk.mockk
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import org.w4.api.movies.dto.MovieDetailsDto
import java.math.BigDecimal
import java.util.*

internal class MovieDetailsFetcherTest {
    private val repository: MoviesRepository = mockk()
    private val restTemplate: RestTemplate = mockk()
    private val fetcher: MovieDetailsFetcher = MovieDetailsFetcher(repository, restTemplate).apply {
        apiKey = "098765"
        providerUrl = "http://provider.url"
    }

    @Test
    fun `should get data from external source and parse it correctly`() {
        //given
        val testMovieId = 1L
        val testTitle = "testMovie"
        val testExtId = "12345"
        val testRating = BigDecimal("8.1")
        val testRuntime = "120 min"
        val expectedResult = MovieDetailsDto(testTitle, testRating.toFloat(), testRuntime)
        val url = "http://provider.url?apiKey=098765&i=12345"
        every { repository.findById(testMovieId) } returns Optional.of(
            Movie(
                testMovieId,
                testTitle,
                testExtId,
                mutableListOf()
            )
        )
        every { restTemplate.getForEntity(url, ProviderResponse::class.java) } returns
                ResponseEntity(
                    ProviderResponse(
                        title = testTitle,
                        imdbRating = testRating,
                        runtime = testRuntime
                    ),
                    HttpStatus.OK
                )

        //when
        val result = fetcher.getMovieDetails(testMovieId)

        //then
        assertEquals(expectedResult, result)
    }
}