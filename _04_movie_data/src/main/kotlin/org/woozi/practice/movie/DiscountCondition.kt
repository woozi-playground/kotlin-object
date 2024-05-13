package org.woozi.practice.movie

import java.time.DayOfWeek
import java.time.LocalTime

class DiscountCondition(
    var type: DiscountConditionType,
    var sequence: Int = 0,
    var dayOfWeek: DayOfWeek? = null,
    var startTime: LocalTime? = null,
    var endTime: LocalTime? = null,
) {

    fun isDiscountable(dayOfWeek: DayOfWeek, time: LocalTime?): Boolean {
        require(type === DiscountConditionType.PERIOD)
        return this.dayOfWeek == dayOfWeek && (startTime!! <= time) && (endTime!! >= time)
    }

    fun isDiscountable(sequence: Int): Boolean {
        require(type === DiscountConditionType.SEQUENCE)
        return this.sequence == sequence
    }
}
