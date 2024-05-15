package org.woozi.practice.movie

class TicketSeller(private val ticketOffice: TicketOffice) {
    fun sellTo(audience: Audience) {
        ticketOffice.plusAmount(
            audience.buy(ticketOffice.ticket)
        )
    }
}