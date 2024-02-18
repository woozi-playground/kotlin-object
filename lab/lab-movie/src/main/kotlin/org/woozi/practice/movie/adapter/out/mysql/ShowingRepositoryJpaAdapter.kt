package org.woozi.practice.movie.adapter.out.mysql

import jakarta.persistence.EntityNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.woozi.practice.movie.adapter.out.mysql.mapper.ShowingMapper
import org.woozi.practice.movie.adapter.out.mysql.persistence.ShowingRepositoryJpaRepository
import org.woozi.practice.movie.application.port.out.ShowingRepository
import org.woozi.practice.movie.domain.Showing

@Component
class ShowingRepositoryJpaAdapter(
    private val showingRepositoryJpaRepository: ShowingRepositoryJpaRepository
) : ShowingRepository {
    override fun find(showingId: String): Showing = showingRepositoryJpaRepository.findByIdOrNull(showingId.toLong())
        ?.let(ShowingMapper::toDomain)
        ?: throw EntityNotFoundException()
}