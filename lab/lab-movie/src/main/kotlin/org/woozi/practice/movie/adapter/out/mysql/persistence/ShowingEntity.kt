package org.woozi.practice.movie.adapter.out.mysql.persistence

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.ZonedDateTime

@Table(name = "showing")
@Entity
class ShowingEntity(
    @ManyToOne
    var movieEntity: MovieEntity,
    var sequence: Int,
    var whenScreened: ZonedDateTime,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
) {
}