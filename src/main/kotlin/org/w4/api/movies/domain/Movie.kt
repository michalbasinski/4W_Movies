package org.w4.api.movies.domain

import org.w4.api.movies.dto.MovieDto
import javax.persistence.*

@Entity
@Table(name = "movies")
internal data class Movie(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val extId: String,
    @ElementCollection
    val ratings:MutableList<Float>
) {
    fun toDto() = MovieDto(id, name)
}
