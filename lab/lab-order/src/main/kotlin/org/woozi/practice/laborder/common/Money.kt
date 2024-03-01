package org.woozi.practice.laborder.common

import java.util.function.Function

data class Money(
    val amount: Long
) {

    fun times(rate: Int): Money =
        this.times(rate.toDouble())

    fun times(rate: Double): Money =
        Money((amount * rate).toLong())

    fun isGreaterThanOrEqual(minOrderAmount: Long): Boolean {
        TODO("Not yet implemented")
    }

    fun plus(amount: Money): Money =
        Money(this.amount + (amount.amount))

    companion object {
        val ZERO: Money = Money(0)

        fun <T> sum(bags: Collection<T>, monetary: Function<T, Money>): Money =
            bags.stream().map(monetary::apply).reduce(ZERO, Money::plus)
    }
}