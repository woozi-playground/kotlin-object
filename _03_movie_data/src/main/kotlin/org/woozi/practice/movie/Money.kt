package org.woozi.practice.movie

import java.math.BigDecimal

data class Money(
    var amount: BigDecimal
) {
    fun times(count: Int): Money = this.times(count.toDouble())

    fun times(percent: Double): Money = Money(amount.multiply(BigDecimal(percent)))

    fun plus(amount: Money): Money = Money(this.amount.add(amount.amount))

    fun minus(amount: Money): Money = Money(this.amount.subtract(amount.amount))

    companion object {
        val ZERO = Money(BigDecimal.ZERO)
    }
}
