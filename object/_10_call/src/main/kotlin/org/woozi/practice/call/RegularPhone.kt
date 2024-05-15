package org.woozi.practice.call

import java.time.Duration

/**
 * 일반 요금제.
 */
class RegularPhone(
    private var amount: Money,
    private var seconds: Duration,
    taxRate: Double = 0.0,
    calls: List<Call> = ArrayList()
) : Phone(taxRate, calls) {


    override fun calculateCallFee(call: Call): Money {
        return amount.times(call.duration.seconds / seconds.seconds)
    }
}