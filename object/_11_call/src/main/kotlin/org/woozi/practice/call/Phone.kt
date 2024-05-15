package org.woozi.practice.call



open class Phone(
    private val ratePolicy: RatePolicy,
    private val _calls: List<Call>
) {
    val calls: List<Call> get() = _calls.toList()

    fun calculateFee(): Money {
        return ratePolicy.calculateFee(this)
    }
}