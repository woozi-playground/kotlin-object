package org.woozi.practice.movie.application.port.out

import org.woozi.practice.movie.domain.common.DomainEvent

interface DomainEventPublisher {
    fun publishEvent(domainEvent: DomainEvent)
}