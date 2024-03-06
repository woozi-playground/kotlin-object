package org.woozi.practice.movie

import java.time.LocalDateTime

class Screening(
    var movie: Movie,
    var sequence: Int,
    var whenScreened: LocalDateTime
) {
    fun calculateFee(audienceCount: Int): Money {
        when (movie.movieType) {
            MovieType.AMOUNT_DISCOUNT -> if (movie.isDiscountable(whenScreened, sequence)) {
                return movie.calculateAmountDiscountedFee().times(audienceCount)
            }

            MovieType.PERCENT_DISCOUNT -> {
                if (movie.isDiscountable(whenScreened, sequence)) {
                    return movie.calculatePercentDiscountedFee().times(audienceCount)
                }
                return movie.calculateNoneDiscountedFee().times(audienceCount)
            }

            MovieType.NONE_DISCOUNT -> return movie.calculateNoneDiscountedFee().times(audienceCount)
        }
        return movie.calculateNoneDiscountedFee().times(audienceCount)
    }
}