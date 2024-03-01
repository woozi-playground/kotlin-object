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
// 데이터베이스 -> 데이터 지향 / 트랜잭션 스크립트
// <-->
// java -> 객체지향
// Http -> Domain <- DB
// 패러다임 의존성
// DB -> 데이터 지향 / 트랜잭션 스크립트
// Domain -> 객체지향
// 데이터 지향 -> 객체지향 <- 이벤트 드리븐
// 데이터 지향 ==> 객체지향을 할 수 있는 모델링 + 매퍼를 만든다

