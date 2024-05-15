package org.woozi.practice.movie

class AmountDiscountMovie(
    title: String,
    runningTime: Long,
    fee: Money,
    discountConditions: List<DiscountCondition>,
    private val discountAmount: Money,
): Movie(title, runningTime, fee, discountConditions) {

    override fun calculateDiscountAmount(): Money =
        discountAmount
}
