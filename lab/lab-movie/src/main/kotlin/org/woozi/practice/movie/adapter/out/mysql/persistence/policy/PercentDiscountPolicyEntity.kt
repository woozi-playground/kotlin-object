package org.woozi.practice.movie.adapter.out.mysql.persistence.policy

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

@DiscriminatorValue(DiscountPolicyEntityType.Values.PERCENT)
@Entity
class PercentDiscountPolicyEntity(
    val percent: Double
) : DiscountPolicyEntity() {
    override fun discountPolicyType(): DiscountPolicyEntityType {
        return DiscountPolicyEntityType.PERCENT
    }
}