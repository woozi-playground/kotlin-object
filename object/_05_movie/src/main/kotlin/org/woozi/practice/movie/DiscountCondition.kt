package org.woozi.practice.movie

fun interface DiscountCondition {
    fun isSatisfiedBy(screening: Screening): Boolean
}