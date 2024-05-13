package org.woozi.practice.movie

import java.time.Duration
import java.time.LocalDateTime

data class Movie(
    var title: String,
    var runningTime: Duration,
    var fee: Money,
    var discountConditions: List<DiscountCondition>,
    var movieType: MovieType,
    var discountAmount: Money,
    var discountPercent: Double
) {


    fun calculateAmountDiscountedFee(): Money {
        require(movieType === MovieType.AMOUNT_DISCOUNT)
        return fee.minus(discountAmount)
    }

    fun calculatePercentDiscountedFee(): Money {
        require(movieType === MovieType.PERCENT_DISCOUNT)
        return fee.minus(fee.times(discountPercent))
    }

    fun calculateNoneDiscountedFee(): Money {
        require(movieType === MovieType.NONE_DISCOUNT)
        return fee
    }

    /**
     * 할인 조건을 하나씩 훑어 가면서 할인 조건의 타입을 체크한 다음, 할인 가능 여부를 리턴한다.
     *
     * @param whenScreened 상영일시
     * @param sequence     상영순번
     * @return 할인 가능하다면 true
     */
    fun isDiscountable(whenScreened: LocalDateTime, sequence: Int): Boolean {
        for (condition in discountConditions) {
            if (condition.type === DiscountConditionType.PERIOD) {
                if (condition.isDiscountable(whenScreened.dayOfWeek, whenScreened.toLocalTime())) {
                    return true
                }
            } else {
                if (condition.isDiscountable(sequence)) {
                    return true
                }
            }
        }
        return false
    }
}