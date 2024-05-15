package org.woozi.practice.call.policy.basic

import org.woozi.practice.call.Money
import org.woozi.practice.call.Phone

interface RatePolicy {
    fun calculateFee(phone: Phone): Money
}