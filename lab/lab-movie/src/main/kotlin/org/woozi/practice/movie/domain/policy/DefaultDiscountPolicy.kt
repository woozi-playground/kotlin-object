package org.woozi.practice.movie.domain.policy

import org.woozi.practice.movie.domain.Money
import org.woozi.practice.movie.domain.Showing
import org.woozi.practice.movie.domain.policy.condition.DiscountCondition

abstract class DefaultDiscountPolicy(
    private val conditions: List<DiscountCondition>
) : DiscountPolicy {
    override fun calculateDiscountAmount(showing: Showing): Money {
        for (condition in conditions) {
            if (condition.isSatisfiedBy(showing)) {
                return getDiscountAmount(showing)
            }
        }
        return Money.ZERO
    }

    abstract fun getDiscountAmount(showing: Showing): Money
}