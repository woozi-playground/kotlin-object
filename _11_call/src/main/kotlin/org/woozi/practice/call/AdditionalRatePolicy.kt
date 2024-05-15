package org.woozi.practice.call

abstract class AdditionalRatePolicy(private val next: RatePolicy) : RatePolicy {

    override fun calculateFee(phone: Phone): Money =
        afterCalculated(next.calculateFee(phone))

    protected abstract fun afterCalculated(fee: Money): Money
}