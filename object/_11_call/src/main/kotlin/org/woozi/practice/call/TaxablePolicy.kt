package org.woozi.practice.call

class TaxablePolicy(
    private val taxRatio: Double = 0.0,
    next: RatePolicy
) : AdditionalRatePolicy(next) {

    override fun afterCalculated(fee: Money): Money =
        fee.plus(fee.times(taxRatio))
}