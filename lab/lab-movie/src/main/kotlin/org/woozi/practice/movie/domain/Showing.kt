package org.woozi.practice.movie.domain

import java.time.ZonedDateTime

data class Showing(
    val id: String,
    val movie: Movie,
    val sequence: Int,
    val whenScreened: ZonedDateTime
) {

    fun reserve(customer: Reserver, audienceCount: Int): Reservation =
        Reservation(customer, this, calculateFee(audienceCount), audienceCount)

    private fun calculateFee(audienceCount: Int): Money =
        movie.calculateMovieFee(this).times(audienceCount.toDouble())

    fun isSequence(sequence: Int): Boolean =
        this.sequence == sequence

    fun getStartTime(): ZonedDateTime =
        whenScreened

    fun getMovieFee(): Money =
        movie.fee
}