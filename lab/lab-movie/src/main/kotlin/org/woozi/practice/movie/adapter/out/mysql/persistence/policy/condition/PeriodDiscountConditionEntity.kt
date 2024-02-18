package org.woozi.practice.movie.adapter.out.mysql.persistence.policy.condition

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import java.time.DayOfWeek
import java.time.ZonedDateTime

@DiscriminatorValue(DiscountConditionEntityType.Values.PERIOD)
@Entity
class PeriodDiscountConditionEntity(
    var dayOfWeek: DayOfWeek,
    var startTime: ZonedDateTime,
    var endTime: ZonedDateTime,
) : DiscountConditionEntity() {
    override fun conditionType(): DiscountConditionEntityType =
        DiscountConditionEntityType.PERIOD
}