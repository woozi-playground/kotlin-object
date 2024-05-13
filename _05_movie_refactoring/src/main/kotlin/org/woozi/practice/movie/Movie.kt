package org.woozi.practice.movie

class Movie(
    private val title: String,
    private val runningTime: Long,
    val fee: Money,
    val discountConditions: List<DiscountCondition>,
    val movieType: MovieType,
    val discountAmount: Money,
    val discountPercent: Double
)
