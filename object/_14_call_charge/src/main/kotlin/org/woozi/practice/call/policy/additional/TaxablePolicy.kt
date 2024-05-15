package org.woozi.practice.call.policy.additional

import org.woozi.practice.call.Money
import org.woozi.practice.call.policy.AdditionalRatePolicy
import org.woozi.practice.call.policy.basic.RatePolicy

class TaxablePolicy(
    private val taxRatio: Double = 0.0,
    next: RatePolicy
) : AdditionalRatePolicy(next) {

    override fun afterCalculated(fee: Money): Money =
        fee.plus(fee.times(taxRatio))
}