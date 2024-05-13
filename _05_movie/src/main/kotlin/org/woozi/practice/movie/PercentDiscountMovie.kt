package org.woozi.practice.movie

class PercentDiscountMovie(
    title: String,
    runningTime: Long,
    fee: Money,
    discountConditions: List<DiscountCondition>,
    private val percent: Double
): Movie(title, runningTime, fee, discountConditions) {

    override fun calculateDiscountAmount(): Money =
        fee.times(percent)
}
