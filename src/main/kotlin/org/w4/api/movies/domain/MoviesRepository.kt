package org.w4.api.movies.domain

import org.springframework.data.jpa.repository.JpaRepository

internal interface MoviesRepository : JpaRepository<Movie, Long>
