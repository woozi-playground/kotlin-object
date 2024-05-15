package org.woozi.practice.call

import java.time.Duration
import java.time.LocalDateTime

/**
 * 개별 통화 시간.
 */
class Call(private val _from: LocalDateTime, private val _to: LocalDateTime) {
    val interval: DateTimeInterval
        get() = DateTimeInterval.of(_from, _to)

    val duration: Duration
        get() = interval.duration()

    val from: LocalDateTime
        get() = interval.from

    val to: LocalDateTime
        get() = interval.to

    fun splitByDay(): List<DateTimeInterval> =
        interval.splitByDay()
}