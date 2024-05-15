package org.woozi.practice.call

import org.woozi.practice.call.policy.BasicRatePolicy
import org.woozi.practice.call.policy.additional.RateDiscountablePolicy
import org.woozi.practice.call.policy.additional.TaxablePolicy
import org.woozi.practice.call.policy.basic.FeeRule
import org.woozi.practice.call.policy.basic.condition.DayOfWeekFeeCondition
import org.woozi.practice.call.policy.basic.condition.TimeOfDayFeeCondition
import org.woozi.practice.call.policy.basic.duration.FeePerDuration
import java.math.BigDecimal
import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime

fun main() {
    val feeRules = listOf(
        FeeRule(
            TimeOfDayFeeCondition(LocalTime.of(0, 0), LocalTime.of(19, 0)),
            FeePerDuration(Money(BigDecimal("0.05")), Duration.ofSeconds(10))
        ),
        FeeRule(
            TimeOfDayFeeCondition(LocalTime.of(19, 0), LocalTime.of(23, 59, 59, 999_999_999)),
            FeePerDuration(Money(BigDecimal("0.05")), Duration.ofSeconds(10))
        )
    )
    val phone = Phone(
        RateDiscountablePolicy(
            Money(BigDecimal("1")),
            TaxablePolicy(0.01, BasicRatePolicy(feeRules))
        ),
        listOf(
            Call(
                LocalDateTime.of(2024, 5, 15, 0, 0),
                LocalDateTime.of(2024, 5, 16, 0, 0)
            ),
        )
    )
    val calculateFee = phone.calculateFee()
    println(calculateFee)
}
