package org.woozi.practice.call

import java.math.BigDecimal
import java.time.Duration
import java.time.LocalDateTime

fun main() {
    val taxablePolicy: RatePolicy = TaxablePolicy(
        0.1,
        RateDiscountablePolicy(Money(BigDecimal(1)), RegularPolicy(Money(BigDecimal("0.5")), Duration.ofSeconds(10)))
    )
    val phone = Phone(taxablePolicy, listOf(Call(LocalDateTime.of(2024, 5, 15, 22, 0), LocalDateTime.of(2024, 5, 15, 23, 0))))
    val calculateFee = phone.calculateFee()
    println(calculateFee)
}
