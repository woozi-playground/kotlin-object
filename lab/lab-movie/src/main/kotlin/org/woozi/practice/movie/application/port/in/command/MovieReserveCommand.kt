package org.woozi.practice.movie.application.port.`in`.command

data class MovieReserveCommand(
    val showingId: String,
    val reserverId: String,
    val audienceCount: Int,
)
