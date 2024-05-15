package org.woozi.practice.call

class RateDiscountablePolicy(
    private val discountAmount: Money,
    next: RatePolicy
) : AdditionalRatePolicy(next) {
    override fun afterCalculated(fee: Money): Money =
        fee.minus(discountAmount)
}