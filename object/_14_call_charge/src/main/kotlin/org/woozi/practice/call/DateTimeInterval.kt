package org.woozi.practice.call

import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class DateTimeInterval private constructor(val from: LocalDateTime, val to: LocalDateTime) {
    fun duration(): Duration =
        Duration.between(from, to)

    fun splitByDay(): List<DateTimeInterval> {
        if (days() > 0) {
            return split(days())
        }
        return listOf(this)
    }

    private fun days(): Long =
        Duration.between(from.toLocalDate().atStartOfDay(), to.toLocalDate().atStartOfDay()).toDays()

    private fun split(days: Long): List<DateTimeInterval> {
        val result: MutableList<DateTimeInterval> = ArrayList()
        addFirstDay(result)
        addMiddleDays(result, days)
        addLastDay(result)
        return result
    }

    private fun addFirstDay(result: MutableList<DateTimeInterval>) {
        result.add(toMidnight(from))
    }

    private fun addMiddleDays(result: MutableList<DateTimeInterval>, days: Long) {
        for (loop in 1 until days) {
            result.add(during(from.toLocalDate().plusDays(loop.toLong())))
        }
    }

    private fun addLastDay(result: MutableList<DateTimeInterval>) {
        result.add(fromMidnight(to))
    }

    override fun toString(): String =
        "[ $from - $to ]"

    companion object {
        fun of(from: LocalDateTime, to: LocalDateTime): DateTimeInterval = DateTimeInterval(from, to)

        fun toMidnight(from: LocalDateTime): DateTimeInterval =
            DateTimeInterval(from, LocalDateTime.of(from.toLocalDate(), LocalTime.of(23, 59, 59, 999999999)))

        fun fromMidnight(to: LocalDateTime): DateTimeInterval =
            DateTimeInterval(LocalDateTime.of(to.toLocalDate(), LocalTime.of(0, 0)), to)

        fun during(date: LocalDate?): DateTimeInterval = DateTimeInterval(
            LocalDateTime.of(date, LocalTime.of(0, 0)),
            LocalDateTime.of(date, LocalTime.of(23, 59, 59, 999999999))
        )
    }
}