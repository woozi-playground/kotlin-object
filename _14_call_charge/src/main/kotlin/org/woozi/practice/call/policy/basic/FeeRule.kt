package org.woozi.practice.call.policy.basic

import org.woozi.practice.call.Call
import org.woozi.practice.call.Money
import org.woozi.practice.call.policy.basic.condition.DayOfWeekFeeCondition
import org.woozi.practice.call.policy.basic.duration.FeePerDuration

class FeeRule(
    private val feeConditions: FeeCondition,
    private val feePerDuration: FeePerDuration
) {
    fun calculateFee(call: Call): Money {
        return feeConditions.findTimeIntervals(call)
            .map(feePerDuration::calculate)
            .fold(Money.ZERO, Money::plus)
    }
}