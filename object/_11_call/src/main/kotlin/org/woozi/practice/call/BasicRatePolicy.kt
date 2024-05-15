package org.woozi.practice.call

abstract class BasicRatePolicy : RatePolicy {

    override fun calculateFee(phone: Phone): Money =
        phone.calls.fold(Money.ZERO) { money, call -> money.plus(calculateCallFee(call))
    }

    protected abstract fun calculateCallFee(call: Call): Money
}