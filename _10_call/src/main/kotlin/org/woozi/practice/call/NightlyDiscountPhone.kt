package org.woozi.practice.call

import java.time.Duration

/**
 * 심야 할인 요금제.
 */
class NightlyDiscountPhone(
    private var nightlyAmount: Money,
    private var regularAmount: Money,
    private var seconds: Duration,
    taxRate: Double = 0.0,
    calls: List<Call> = ArrayList()
) : Phone(taxRate, calls) {

    override fun calculateCallFee(call: Call): Money {
        if (call.from.hour >= LATE_NIGHT_HOUR) {
            return nightlyAmount.times(call.duration.seconds / seconds.seconds)
        }
        return regularAmount.times(call.duration.seconds / seconds.seconds)
    }

    companion object {
        private const val LATE_NIGHT_HOUR = 22
    }
}