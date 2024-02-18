package org.woozi.practice.movie.adapter.out.http

import org.springframework.stereotype.Component
import org.woozi.practice.movie.application.port.out.ReserveClient
import org.woozi.practice.movie.domain.Reserver

@Component
class ReserveClientHttpImpl: ReserveClient {
    override fun find(userId: String): Reserver {
        return Reserver("1", "test")
    }
}