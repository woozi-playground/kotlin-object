package org.woozi.practice.call

interface RatePolicy {
    fun calculateFee(phone: Phone): Money
}