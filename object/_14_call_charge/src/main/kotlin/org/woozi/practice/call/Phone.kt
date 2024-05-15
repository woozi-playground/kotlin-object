package org.woozi.practice.call

import org.woozi.practice.call.policy.basic.RatePolicy

open class Phone(
    private val ratePolicy: RatePolicy,
    private val _calls: List<Call> = ArrayList()
) {
    val calls: List<Call> get() = _calls.toList()

    fun calculateFee(): Money =
        ratePolicy.calculateFee(this)

    fun call(call: Call) {
    }
}