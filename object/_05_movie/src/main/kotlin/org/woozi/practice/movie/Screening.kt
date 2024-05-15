package org.woozi.practice.movie

import java.time.ZonedDateTime

data class Screening(
    private val movie: Movie,
    private val sequence: Int,
    private val whenScreened: ZonedDateTime
) {

    fun reserve(customer: Customer, audienceCount: Int): Reservation =
        Reservation(customer, this, calculateFee(audienceCount), audienceCount)

    private fun calculateFee(audienceCount: Int): Money =
        movie.calculateMovieFee(this).times(audienceCount.toDouble())

    fun isSequence(sequence: Int): Boolean =
        this.sequence == sequence

    fun getStartTime(): ZonedDateTime =
        whenScreened
}