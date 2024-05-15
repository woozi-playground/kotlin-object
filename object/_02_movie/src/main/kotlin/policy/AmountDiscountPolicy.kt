package policy

import Money
import Screening
import policy.condition.DiscountCondition

class AmountDiscountPolicy(
    private val discountAmount: Money,
    conditions: List<DiscountCondition>,
) : DefaultDiscountPolicy(conditions) {

    override fun getDiscountAmount(screening: Screening): Money =
        discountAmount
}