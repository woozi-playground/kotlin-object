package org.woozi.practice.movie.application.port.out

import org.woozi.practice.movie.domain.Reservation

interface ReservationRepository {
    fun save(reservation: Reservation)
}
