package org.woozi.practice.call

import java.math.BigDecimal
import java.math.RoundingMode

data class Money(
    private val amount: BigDecimal
) {

    fun times(percent: Long): Money = times(BigDecimal(percent))

    fun times(percent: Double): Money = times(BigDecimal(percent))

    fun times(percent: BigDecimal): Money = Money(amount.multiply(percent).setScale(0, RoundingMode.FLOOR))

    fun plus(amount: Money): Money = Money(this.amount.add(amount.amount))

    fun minus(amount: Money): Money = Money(this.amount.subtract(amount.amount))

    fun divide(count: Double) = Money(amount.divide(BigDecimal(count)))



    companion object {
        val ZERO = Money(BigDecimal.ZERO)
    }
}
