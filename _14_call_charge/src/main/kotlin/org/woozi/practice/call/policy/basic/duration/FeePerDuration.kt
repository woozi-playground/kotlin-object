package org.woozi.practice.call.policy.basic.duration

import org.woozi.practice.call.DateTimeInterval
import org.woozi.practice.call.Money
import java.time.Duration

class FeePerDuration(private val fee: Money, private val duration: Duration) {

    fun calculate(interval: DateTimeInterval): Money =
        fee.times(interval.duration().seconds / duration.seconds)
}