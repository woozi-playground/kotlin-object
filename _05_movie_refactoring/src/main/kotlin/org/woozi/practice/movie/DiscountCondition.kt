package org.woozi.practice.movie

import java.time.DayOfWeek
import java.time.ZonedDateTime

class DiscountCondition(
    private val type: DiscountConditionType,
    private val sequence: Int = 0,
    private val dayOfWeek: DayOfWeek? = null,
    private val startTime: ZonedDateTime? = null,
    private val endTime: ZonedDateTime? = null
) {

    fun isDiscountable(screening: Screening): Boolean {
        if (type == DiscountConditionType.PERIOD) {
            return isSatisfiedByPeriod(screening)
        }
        return isSatisfiedBySequence(screening)
    }

    private fun isSatisfiedByPeriod(screening: Screening): Boolean {
        return (screening.whenScreened.dayOfWeek == dayOfWeek
            && startTime!!.isBefore(screening.whenScreened)
            && endTime!!.isAfter(screening.whenScreened))
    }

    private fun isSatisfiedBySequence(screening: Screening): Boolean {
        return sequence == screening.sequence
    }
}
