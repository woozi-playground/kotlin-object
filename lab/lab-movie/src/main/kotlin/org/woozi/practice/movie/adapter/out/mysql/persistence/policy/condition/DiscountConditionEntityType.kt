package org.woozi.practice.movie.adapter.out.mysql.persistence.policy.condition

enum class DiscountConditionEntityType(
    val value: String
) {
    PERIOD(Values.PERIOD),
    SEQUENCE(Values.SEQUENCE),
    ;

    object Values {
        const val PERIOD: String = "PERIOD"
        const val SEQUENCE: String = "SEQUENCE"
    }
}