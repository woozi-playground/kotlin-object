package org.woozi.practice.movie

import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalTime

data class RecurringSchedule(
    val subject: String,
    val dayOfWeek: DayOfWeek,
    val from: LocalTime,
    val duration: Duration
)