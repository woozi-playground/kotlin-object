package org.woozi.practice.laborder.common

data class Ratio(
    private val rate: Double = 0.0
) {

    fun of(price: Money): Money =
        price.times(rate)

    companion object {
        fun valueOf(rate: Double): Ratio {
            return Ratio(rate)
        }
    }
}