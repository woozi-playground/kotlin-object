package org.woozi.practice.movie.domain.policy.condition

import org.woozi.practice.movie.domain.Showing

fun interface DiscountCondition {
    fun isSatisfiedBy(showing: Showing): Boolean
}