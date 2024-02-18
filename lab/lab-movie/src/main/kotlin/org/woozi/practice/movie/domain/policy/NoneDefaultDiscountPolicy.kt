package org.woozi.practice.movie.domain.policy

import org.woozi.practice.movie.domain.Money
import org.woozi.practice.movie.domain.Showing

class NoneDefaultDiscountPolicy : DiscountPolicy {
    override fun calculateDiscountAmount(showing: Showing): Money =
        Money.ZERO
}
