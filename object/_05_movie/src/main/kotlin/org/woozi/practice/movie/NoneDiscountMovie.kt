package org.woozi.practice.movie

class NoneDiscountMovie(
    title: String,
    runningTime: Long,
    fee: Money,
    discountConditions: List<DiscountCondition>,
): Movie(title, runningTime, fee, discountConditions) {

    override fun calculateDiscountAmount(): Money {
        return Money.ZERO
    }
}
