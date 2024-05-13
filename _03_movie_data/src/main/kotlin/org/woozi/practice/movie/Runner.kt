package org.woozi.practice.movie

import java.math.BigDecimal
import java.time.Duration
import java.time.LocalDateTime
import java.util.UUID

fun main() {
    val reservationAgency = ReservationAgency()
    val customer = Customer(UUID.randomUUID().toString(), "woozi")
    val movie = Movie(
        "반지의 제왕",
        Duration.ofMinutes(180),
        Money(BigDecimal(10000)),
        listOf(DiscountCondition(DiscountConditionType.SEQUENCE, 1, null, null, null)),
        MovieType.AMOUNT_DISCOUNT,
        Money(BigDecimal(1000)),
        0.1
    )
    val reservation = reservationAgency.reserve(
        Screening(movie, 1, LocalDateTime.of(2024, 5, 13, 0, 0)),
        customer,
        2
    )
    println(reservation)
}