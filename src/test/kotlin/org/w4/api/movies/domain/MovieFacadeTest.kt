package org.w4.api.movies.domain

import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import junit.framework.Assert.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

internal class MovieFacadeTest {

    private val repository: MoviesRepository = mockk()
    private val fetcher: MovieDetailsFetcher = mockk()
    private val facade = MovieFacade(repository, fetcher)

    @Test
    fun `should update movie with rating`() {
        //given
        val testId = 1L
        val extId = "1"
        val title = "test title"
        val rating = 5.0F
        val expectedRatingsCount = 1

        val capturedArgument = slot<Movie>()
        every { repository.findById(testId) } returns Optional.of(Movie(testId, title, extId, mutableListOf()))
        every { repository.save(capture(capturedArgument)) } returns mockk()

        //when
        facade.rateMovie(testId, rating)

        //then
        assertEquals(expectedRatingsCount, capturedArgument.captured.ratings.size)
        assertEquals(rating, capturedArgument.captured.ratings[0])
    }
}