package org.woozi.practice.movie.adapter.out.mysql.persistence.policy

enum class DiscountPolicyEntityType(
    val value: String
) {
    PERCENT(Values.PERCENT),
    AMOUNT(Values.AMOUNT),
    NONE(Values.NONE)
    ;

    object Values {
        const val PERCENT: String = "PERCENT"
        const val AMOUNT: String = "AMOUNT"
        const val NONE: String = "NONE"
    }
}