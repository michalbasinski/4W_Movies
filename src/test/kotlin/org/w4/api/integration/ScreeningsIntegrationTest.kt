package org.w4.api.integration

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.w4.api.screenings.domain.ScreeningRepository
import org.w4.api.screenings.dtos.NewScreeningDto
import org.w4.api.screenings.dtos.ScreeningDto
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ScreeningsIntegrationTest {

    @LocalServerPort
    var port: Int? = null

    @Autowired
    lateinit var screeningsRepository: ScreeningRepository

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun `should add new screening`() {
        //given
        val date = LocalDateTime.now()
        val price = "40 PLN"
        val initialSize = screeningsRepository.count()

        //when
        val result = testRestTemplate.postForEntity(
            "http://localhost:$port/internal/screenings",
            NewScreeningDto(1L, date, price),
            ScreeningDto::class.java
        )

        //then
        val finalCount = screeningsRepository.count()
        assertEquals(initialSize + 1, finalCount)
    }

    @Test
    fun `should find exactly one screening`() {
        //given
        val expectedScreening = ScreeningDto(
            title = "Fast & Furious",
            movieId = 4,
            price = "10 PLN",
            date = LocalDateTime.of(LocalDate.of(2020, 5, 5), LocalTime.of(15, 0))
        )

        //when
        val result = testRestTemplate.getForEntity(
            "http://localhost:$port/screenings?from=2019-04-20T00:00:00&to=2021-04-20T00:00:00",
            Array<ScreeningDto>::class.java
        ).body

        //then
        assertEquals(1, result?.size)
        assertEquals(expectedScreening, result?.get(0))
    }
}