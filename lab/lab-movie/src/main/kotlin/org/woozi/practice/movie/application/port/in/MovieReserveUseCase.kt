package org.woozi.practice.movie.application.port.`in`

import org.woozi.practice.movie.application.port.`in`.command.MovieReserveCommand

interface MovieReserveUseCase {
    fun reserveMovie(toCommand: MovieReserveCommand)
}