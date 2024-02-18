package org.woozi.practice.movie.adapter.out.mysql.persistence.policy.condition

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

@DiscriminatorValue(DiscountConditionEntityType.Values.SEQUENCE)
@Entity
class SequenceDiscountConditionEntity(
    var sequence: Int
) : DiscountConditionEntity() {
    override fun conditionType(): DiscountConditionEntityType =
        DiscountConditionEntityType.SEQUENCE
}