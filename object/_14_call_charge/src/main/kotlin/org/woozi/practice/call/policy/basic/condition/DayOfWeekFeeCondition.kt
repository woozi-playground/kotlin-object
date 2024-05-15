package org.woozi.practice.call.policy.basic.condition

import org.woozi.practice.call.Call
import org.woozi.practice.call.DateTimeInterval
import org.woozi.practice.call.policy.basic.FeeCondition
import java.time.DayOfWeek

class DayOfWeekFeeCondition(
    private val dayOfWeeks: List<DayOfWeek>
) : FeeCondition {

    constructor(vararg dayOfWeeks: DayOfWeek) : this(listOf(*dayOfWeeks))

    override fun findTimeIntervals(call: Call): List<DateTimeInterval> =
        call.interval
            .splitByDay()
            .filter { dayOfWeeks.contains(it.from.dayOfWeek) }
}