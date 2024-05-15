package org.woozi.practice.call.policy

import org.woozi.practice.call.Call
import org.woozi.practice.call.policy.basic.FeeRule
import org.woozi.practice.call.Money
import org.woozi.practice.call.Phone
import org.woozi.practice.call.policy.basic.RatePolicy

open class BasicRatePolicy(
    private var feeRules: List<FeeRule> = ArrayList()
) : RatePolicy {
    constructor(vararg feeRules: FeeRule) : this(listOf(*feeRules))

    override fun calculateFee(phone: Phone): Money {
        return phone.calls
            .map(::calculate)
            .fold(Money.ZERO, Money::plus)
    }

    private fun calculate(call: Call): Money {
        return feeRules
            .map { it.calculateFee(call) }
            .fold(Money.ZERO, Money::plus)
    }
}
