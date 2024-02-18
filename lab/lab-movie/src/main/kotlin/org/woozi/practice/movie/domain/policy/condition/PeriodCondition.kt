package org.woozi.practice.movie.domain.policy.condition

import org.woozi.practice.movie.domain.Showing
import java.time.DayOfWeek
import java.time.ZonedDateTime

data class PeriodCondition(
    private val dayOfWeek: DayOfWeek,
    private val startTime: ZonedDateTime,
    private val endTime: ZonedDateTime
) : DiscountCondition {

    override fun isSatisfiedBy(showing: Showing): Boolean =
        showing.getStartTime().dayOfWeek == dayOfWeek &&
            startTime <= showing.getStartTime() &&
            endTime >= showing.getStartTime()
}
