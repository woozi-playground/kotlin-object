import java.math.BigDecimal
import java.math.RoundingMode

data class Money(
    private val amount: BigDecimal
) {

    fun times(percent: Double): Money = Money(amount.multiply(BigDecimal(percent)).setScale(0, RoundingMode.FLOOR))

    fun plus(amount: Money): Money = Money(this.amount.add(amount.amount))

    fun minus(amount: Money): Money = Money(this.amount.subtract(amount.amount))

    fun divide(count: Double) = Money(amount.divide(BigDecimal(count)))

    companion object {
        val ZERO = Money(BigDecimal.ZERO)
    }
}
