package org.w4.api.movies.domain

import jakarta.persistence.*
import org.w4.api.movies.dto.MovieDto

@Entity
@Table(name = "movies")
internal data class Movie(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val extId: String,
    @ElementCollection
    val ratings:List<Float>
) {
    fun toDto() = MovieDto(id, name)
}
