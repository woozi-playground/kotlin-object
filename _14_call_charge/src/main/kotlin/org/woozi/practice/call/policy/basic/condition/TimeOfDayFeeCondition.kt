package org.woozi.practice.call.policy.basic.condition

import org.woozi.practice.call.Call
import org.woozi.practice.call.DateTimeInterval
import org.woozi.practice.call.policy.basic.FeeCondition
import java.time.LocalDateTime
import java.time.LocalTime

class TimeOfDayFeeCondition(private val from: LocalTime, private val to: LocalTime) : FeeCondition {
    override fun findTimeIntervals(call: Call): List<DateTimeInterval> {
        return call.interval.splitByDay()
            .filter { from(it).isBefore(to(it)) }
            .map {
                DateTimeInterval.of(
                    LocalDateTime.of(it.from.toLocalDate(), from(it)),
                    LocalDateTime.of(it.to.toLocalDate(), to(it))
                )
            }
    }

    private fun from(interval: DateTimeInterval): LocalTime =
        if (interval.from.toLocalTime().isBefore(from)) from else interval.from.toLocalTime()

    private fun to(interval: DateTimeInterval): LocalTime =
        if (interval.to.toLocalTime().isAfter(to)) to else interval.to.toLocalTime()
}