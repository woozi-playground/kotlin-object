package org.woozi.practice.call.policy

import org.woozi.practice.call.Money
import org.woozi.practice.call.Phone
import org.woozi.practice.call.policy.basic.RatePolicy

class EmptyRatePolicy: RatePolicy {
    override fun calculateFee(phone: Phone): Money {
        return Money.ZERO
    }
}