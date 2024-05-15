import policy.DiscountPolicy

data class Movie(
    private val title: String,
    private val runningTime: Long,
    private val fee: Money,
    var discountPolicy: DiscountPolicy
) {

    fun changeDiscountPolicy(discountPolicy: DiscountPolicy) {
        this.discountPolicy = discountPolicy
    }

    fun calculateMovieFee(screening: Screening): Money =
        discountPolicy.calculateDiscountAmount(screening).let(fee::minus)

    fun getFee(): Money =
        fee
}
