package org.woozi.practice.movie.domain

import org.woozi.practice.movie.domain.policy.DiscountPolicy
import org.woozi.practice.movie.domain.policy.NoneDefaultDiscountPolicy

data class Movie(
    val title: String,
    val runningTime: Long,
    val fee: Money,
    val discountPolicy: DiscountPolicy = NoneDefaultDiscountPolicy()
) {

    fun changeDiscountPolicy(discountPolicy: DiscountPolicy): Movie {
        return Movie(this.title, this.runningTime, this.fee, discountPolicy)
    }

    fun calculateMovieFee(showing: Showing): Money =
        discountPolicy.calculateDiscountAmount(showing).let(fee::minus)
}
