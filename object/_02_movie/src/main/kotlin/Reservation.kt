data class Reservation(
    private val customer: Customer,
    private val screening: Screening,
    private val fee: Money,
    private val audienceCount: Int
) {
    fun eachPayMoney(): Money =
        fee.divide(audienceCount.toDouble())
}
