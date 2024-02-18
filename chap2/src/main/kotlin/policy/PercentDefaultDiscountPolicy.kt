package policy

import Money
import Screening
import policy.condition.DiscountCondition

class PercentDefaultDiscountPolicy(
    private val percent: Double,
    conditions: List<DiscountCondition>
): DefaultDiscountPolicy(conditions) {

    override fun getDiscountAmount(screening: Screening): Money =
        screening.getMovieFee().times(percent)
}