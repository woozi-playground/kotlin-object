package org.woozi.practice.movie.adapter.out.mysql

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.woozi.practice.movie.adapter.out.mysql.persistence.ReservationEntity
import org.woozi.practice.movie.adapter.out.mysql.persistence.ReservationJpaRepository
import org.woozi.practice.movie.adapter.out.mysql.persistence.ShowingRepositoryJpaRepository
import org.woozi.practice.movie.application.port.out.ReservationRepository
import org.woozi.practice.movie.domain.Reservation

@Component
class ReservationJpaAdapter(
    private val reservationRepository: ReservationJpaRepository,
    private val showingRepository: ShowingRepositoryJpaRepository,
): ReservationRepository {

    override fun save(reservation: Reservation) {
        val showingEntity = (showingRepository.findByIdOrNull(reservation.showing.id.toLong())
            ?: throw RuntimeException())
        ReservationEntity(
            reserverId = reservation.reserver.id.toLong(),
            showing = showingEntity,
            fee = reservation.fee.amount,
            audienceCount = reservation.audienceCount
        ).let {
            reservationRepository.save(it)
        }
    }
}