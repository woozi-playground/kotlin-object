package org.woozi.practice.movie

class Theater(private val ticketSeller: TicketSeller) {
    fun enter(audience: Audience) {
        ticketSeller.sellTo(audience)
    }
}