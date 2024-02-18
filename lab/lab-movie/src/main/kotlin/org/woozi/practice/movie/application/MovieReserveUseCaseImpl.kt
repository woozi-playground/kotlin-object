package org.woozi.practice.movie.application

import org.springframework.stereotype.Service
import org.woozi.practice.movie.application.port.`in`.MovieReserveUseCase
import org.woozi.practice.movie.application.port.`in`.command.MovieReserveCommand
import org.woozi.practice.movie.application.port.out.DomainEventPublisher
import org.woozi.practice.movie.application.port.out.ReservationRepository
import org.woozi.practice.movie.application.port.out.ReserveClient
import org.woozi.practice.movie.application.port.out.ShowingRepository

@Service
class MovieReserveUseCaseImpl(
    private val reserveClient: ReserveClient,
    private val showingRepository: ShowingRepository,
    private val reservationRepository: ReservationRepository,
    private val domainEventPublisher: DomainEventPublisher
): MovieReserveUseCase {

    override fun reserveMovie(command: MovieReserveCommand) {
        val reserver = reserveClient.find(command.reserverId)
        val showing = showingRepository.find(command.showingId)
        val reservation = showing.reserve(reserver, command.audienceCount)
        reservationRepository.save(reservation)
        reservation.reserved(domainEventPublisher::publishEvent)
    }
}
