package policy.condition

import Screening

fun interface DiscountCondition {
    fun isSatisfiedBy(screening: Screening): Boolean
}