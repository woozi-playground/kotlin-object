package org.woozi.practice.movie.adapter.out.mysql.persistence

import org.springframework.data.jpa.repository.JpaRepository

interface ReservationJpaRepository: JpaRepository<ReservationEntity, Long> {
}