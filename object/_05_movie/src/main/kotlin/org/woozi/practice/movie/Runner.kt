package org.woozi.practice.movie

import java.math.BigDecimal
import java.time.ZonedDateTime
import java.util.UUID

fun main() {
    val avatar = AmountDiscountMovie(
        "아바타",
        120L,
        Money(BigDecimal(10000)),
        listOf(SequenceCondition(1)),
        Money(BigDecimal(1000))
    )

    val titanic = NoneDiscountMovie(
        "타이타닉",
        120L,
        Money(BigDecimal(10000)),
        listOf(SequenceCondition(1))
    )

    val starWars = PercentDiscountMovie(
        "스타워즈",
        120L,
        Money(BigDecimal(10000)),
        listOf(SequenceCondition(1)),
        0.1
    )
    val customer = Customer(UUID.randomUUID().toString(), "우지")
    val screening = Screening(avatar, 1, ZonedDateTime.now())
    val reservation = screening.reserve(customer, 2)
    println(reservation)
}
