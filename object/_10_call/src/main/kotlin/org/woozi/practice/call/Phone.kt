package org.woozi.practice.call

abstract class Phone(
    private val taxRate: Double,
    private val calls: List<Call>
) {

    fun calculateFee(): Money {
        var result = calls.fold(Money.ZERO) { money, call ->
            money.plus(calculateCallFee(call))
        }
        return result.plus(result.times(taxRate))
    }

    protected abstract fun calculateCallFee(call: Call): Money
}