package org.woozi.practice.movie.domain.policy.condition

import org.woozi.practice.movie.domain.Showing

data class SequenceCondition(
    private val sequence: Int
) : DiscountCondition {

    override fun isSatisfiedBy(showing: Showing): Boolean =
        showing.isSequence(sequence)
}