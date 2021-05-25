package org.w4.api.movies.domain

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
internal class MovieConfig {
    @Bean
    fun restTemplate(): RestTemplate = RestTemplate()
}