package org.woozi.practice.movie.application.port.out

import org.woozi.practice.movie.domain.Showing

interface ShowingRepository {
    fun find(showingId: String): Showing
}