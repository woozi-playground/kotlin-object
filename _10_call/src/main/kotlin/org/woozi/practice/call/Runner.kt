package org.woozi.practice.call

import java.math.BigDecimal
import java.time.Duration
import java.time.LocalDateTime

fun main() {
    // val call = Call(LocalDateTime.of(2024, 5, 15, 21, 0), LocalDateTime.of(2024, 5, 15, 21, 10))
    // val nightlyDiscountPhone = NightlyDiscountPhone(Money(BigDecimal(0.05)), Money(BigDecimal(0.02)), Duration.ofSeconds(10), 0.01, listOf(call))
    // val calculateFee = nightlyDiscountPhone.calculateFee()

    val call = Call(LocalDateTime.of(2024, 5, 15, 22, 0), LocalDateTime.of(2024, 5, 15, 23, 0))
    val nightlyDiscountPhone = NightlyDiscountPhone(Money(BigDecimal(0.05)), Money(BigDecimal(0.02)), Duration.ofSeconds(10), 0.01, listOf(call))
    val calculateFee = nightlyDiscountPhone.calculateFee()
    println(calculateFee)
}
