package org.woozi.practice.call.policy.additional

import org.woozi.practice.call.Money
import org.woozi.practice.call.policy.AdditionalRatePolicy
import org.woozi.practice.call.policy.basic.RatePolicy

class RateDiscountablePolicy(
    private val discountAmount: Money,
    next: RatePolicy
) : AdditionalRatePolicy(next) {
    override fun afterCalculated(fee: Money): Money =
        fee.minus(discountAmount)
}