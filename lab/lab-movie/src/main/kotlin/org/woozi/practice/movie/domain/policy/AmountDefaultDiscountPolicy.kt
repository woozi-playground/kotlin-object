package org.woozi.practice.movie.domain.policy

import org.woozi.practice.movie.domain.Money
import org.woozi.practice.movie.domain.Showing
import org.woozi.practice.movie.domain.policy.condition.DiscountCondition

class AmountDefaultDiscountPolicy(
    private val discountAmount: Money,
    conditions: List<DiscountCondition>,
) : DefaultDiscountPolicy(conditions) {

    override fun getDiscountAmount(showing: Showing): Money =
        showing.getMovieFee().minus(discountAmount)
}