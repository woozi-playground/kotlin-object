package org.woozi.practice.movie.adapter.`in`.http.dto

import org.woozi.practice.movie.application.port.`in`.command.MovieReserveCommand

data class ReserveMovieRequest(
    val showingId: String,
    val reserverId: String,
    val audienceCount: Int
) {
    fun toCommand(): MovieReserveCommand =
        MovieReserveCommand(showingId, reserverId, audienceCount)
}
