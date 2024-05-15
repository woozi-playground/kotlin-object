package org.woozi.practice.movie

import java.time.Duration
import java.time.LocalDateTime

data class Event(
    private val subject: String,
    private var from: LocalDateTime,
    private var duration: Duration
) {

    fun isSatisfied(schedule: RecurringSchedule): Boolean =
        !(from.dayOfWeek != schedule.dayOfWeek
            || from.toLocalDate().equals(schedule.from)
            || duration != schedule.duration)

    private fun reschedule(schedule: RecurringSchedule) {
        val daysDistance = daysDistance(schedule).toLong()
        from = LocalDateTime.of(from.toLocalDate().plusDays(daysDistance), schedule.from)
        duration = schedule.duration
    }

    private fun daysDistance(schedule: RecurringSchedule): Int =
        schedule.dayOfWeek.value - from.dayOfWeek.value
}