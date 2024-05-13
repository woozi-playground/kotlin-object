import policy.PercentDefaultDiscountPolicy
import policy.condition.PeriodCondition
import java.math.BigDecimal
import java.time.DayOfWeek
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.UUID

fun main() {
    val customer = Customer(UUID.randomUUID().toString(), "woozi")
    val movie = Movie(
        "titanic", 120L, Money(BigDecimal(10000)),
        // AmountDiscountPolicy(Money(BigDecimal(1000)), listOf(SequenceCondition(1)))
        PercentDefaultDiscountPolicy(
            0.1, listOf(
                PeriodCondition(
                    DayOfWeek.MONDAY,
                    ZonedDateTime.of(2024, 5, 13, 0, 0, 0, 0, ZoneId.of("Asia/Seoul")),
                    ZonedDateTime.of(2024, 5, 13, 23, 59, 59, 0, ZoneId.of("Asia/Seoul"))
                )
            )
        )
    )

    val screening = Screening(movie, 1, ZonedDateTime.of(2024, 5, 13, 23, 59, 59, 0, ZoneId.of("Asia/Seoul")))
    val reservation = screening.reserve(customer, 2)
    println(reservation.eachPayMoney())
}
