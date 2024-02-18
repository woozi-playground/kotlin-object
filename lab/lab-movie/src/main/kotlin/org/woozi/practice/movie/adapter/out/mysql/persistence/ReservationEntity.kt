package org.woozi.practice.movie.adapter.out.mysql.persistence

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.math.BigDecimal

@Table(name = "reservation")
@Entity
class ReservationEntity(
    var reserverId: Long,
    @OneToOne
    var showing: ShowingEntity,
    var fee: BigDecimal,
    var audienceCount: Int,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
)