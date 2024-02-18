package org.woozi.practice.movie.application.port.out

import org.woozi.practice.movie.domain.Reserver

interface ReserveClient {
    fun find(userId: String): Reserver
}