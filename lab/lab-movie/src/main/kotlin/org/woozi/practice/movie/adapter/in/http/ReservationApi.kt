package org.woozi.practice.movie.adapter.`in`.http

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.woozi.practice.movie.adapter.`in`.http.dto.ReserveMovieRequest
import org.woozi.practice.movie.application.port.`in`.MovieReserveUseCase

@RestController
class ReservationApi(
   private val movieReserveUseCase: MovieReserveUseCase
) {

    @PostMapping("/reserve")
    fun reserveMovie(@RequestBody request: ReserveMovieRequest) {
        movieReserveUseCase.reserveMovie(request.toCommand())
    }
}