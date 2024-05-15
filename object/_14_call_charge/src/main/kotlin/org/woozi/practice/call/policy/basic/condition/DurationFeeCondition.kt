package org.woozi.practice.call.policy.basic.condition

import org.woozi.practice.call.Call
import org.woozi.practice.call.DateTimeInterval
import org.woozi.practice.call.policy.basic.FeeCondition
import java.time.Duration
import java.time.LocalDateTime

class DurationFeeCondition(
    private val from: Duration,
    private val to: Duration
) : FeeCondition {

    override fun findTimeIntervals(call: Call): List<DateTimeInterval> {
        if (call.interval.duration() < from) {
            return emptyList()
        }
        return listOf(DateTimeInterval.of(call.interval.from.plus(from), to(call)))
    }

    private fun to(call: Call): LocalDateTime {
        if (call.interval.duration() > to) {
            return call.interval.from.plus(to)
        }
        return call.interval.to
    }
}
