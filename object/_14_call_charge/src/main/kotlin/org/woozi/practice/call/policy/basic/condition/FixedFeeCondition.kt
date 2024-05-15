package org.woozi.practice.call.policy.basic.condition

import org.woozi.practice.call.Call
import org.woozi.practice.call.DateTimeInterval
import org.woozi.practice.call.policy.basic.FeeCondition

class FixedFeeCondition : FeeCondition {
    override fun findTimeIntervals(call: Call): List<DateTimeInterval> =
        listOf(call.interval)
}