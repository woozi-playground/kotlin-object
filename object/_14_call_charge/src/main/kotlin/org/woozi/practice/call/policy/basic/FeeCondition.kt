package org.woozi.practice.call.policy.basic

import org.woozi.practice.call.Call
import org.woozi.practice.call.DateTimeInterval

interface FeeCondition {
    fun findTimeIntervals(call: Call): List<DateTimeInterval>
}