package policy.condition

import Screening
import java.time.DayOfWeek
import java.time.ZonedDateTime

data class PeriodCondition(
    private val dayOfWeek: DayOfWeek,
    private val startTime: ZonedDateTime,
    private val endTime: ZonedDateTime
) : DiscountCondition {

    override fun isSatisfiedBy(screening: Screening): Boolean =
        screening.getStartTime().dayOfWeek == dayOfWeek &&
            startTime <= screening.getStartTime() &&
            endTime >= screening.getStartTime()
}
