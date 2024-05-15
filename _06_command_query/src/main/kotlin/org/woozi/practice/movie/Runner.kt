package org.woozi.practice.movie

import java.math.BigDecimal
import java.time.DayOfWeek
import java.time.Duration
import java.time.ZonedDateTime
import java.util.UUID

fun main() {
    val movie = Movie(
        "아바타",
        120L,
        Money(BigDecimal(10000)),
        listOf(DiscountCondition(DiscountConditionType.SEQUENCE, 1)),
        MovieType.AMOUNT_DISCOUNT,
        Money(BigDecimal(1000)),
        0.1
    )
    val customer = Customer(UUID.randomUUID().toString(), "우지")
    val reservationAgency = ReservationAgency()
    val reservation = reservationAgency.reserve(Screening(movie, 1, ZonedDateTime.now()), customer, 2)
    println(reservation)
}
