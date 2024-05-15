package org.woozi.practice.call

import java.time.Duration

class RegularPolicy(private val amount: Money, private val seconds: Duration) : BasicRatePolicy() {
    override fun calculateCallFee(call: Call): Money =
        amount.times(call.duration.seconds / seconds.seconds)
}