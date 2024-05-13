package policy

import Money
import Screening
import policy.condition.DiscountCondition

abstract class DefaultDiscountPolicy(
    private val conditions: List<DiscountCondition> = emptyList()
) : DiscountPolicy {

    override fun calculateDiscountAmount(screening: Screening): Money =
        conditions.firstOrNull { it.isSatisfiedBy(screening) }
            ?.let { getDiscountAmount(screening) }
            ?: Money.ZERO

    abstract fun getDiscountAmount(screening: Screening): Money
}
