package org.woozi.practice.movie.domain.policy

import org.woozi.practice.movie.domain.Money
import org.woozi.practice.movie.domain.Showing

interface DiscountPolicy {
    fun calculateDiscountAmount(showing: Showing): Money
}