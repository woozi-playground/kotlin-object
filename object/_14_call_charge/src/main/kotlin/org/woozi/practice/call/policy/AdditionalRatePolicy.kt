package org.woozi.practice.call.policy

import org.woozi.practice.call.Money
import org.woozi.practice.call.Phone
import org.woozi.practice.call.policy.basic.RatePolicy

abstract class AdditionalRatePolicy(private val next: RatePolicy) : RatePolicy {

    override fun calculateFee(phone: Phone): Money =
        afterCalculated(next.calculateFee(phone))

    protected abstract fun afterCalculated(fee: Money): Money
}