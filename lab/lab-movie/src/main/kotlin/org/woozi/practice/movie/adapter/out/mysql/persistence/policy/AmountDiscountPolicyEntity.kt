package org.woozi.practice.movie.adapter.out.mysql.persistence.policy

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import java.math.BigDecimal

@DiscriminatorValue(DiscountPolicyEntityType.Values.AMOUNT)
@Entity
class AmountDiscountPolicyEntity(
    val discountAmount: BigDecimal
): DiscountPolicyEntity() {
    override fun discountPolicyType(): DiscountPolicyEntityType {
        return DiscountPolicyEntityType.AMOUNT
    }
}