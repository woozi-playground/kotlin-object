package org.woozi.practice.movie

import java.time.ZonedDateTime

data class Screening(
    val movie: Movie,
    val sequence: Int,
    val whenScreened: ZonedDateTime
)