package org.woozi.practice.movie.domain

import org.woozi.practice.movie.domain.common.DomainEvent

data class Reservation(
    val reserver: Reserver,
    val showing: Showing,
    val fee: Money,
    val audienceCount: Int
) {

    fun reserved(eventPublisher: (DomainEvent) -> Unit) {
        eventPublisher(ReservedEvent())
    }

    internal class ReservedEvent: DomainEvent()
}
