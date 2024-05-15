package org.woozi.practice.movie

class Bag(
    private var amount: Long,
    private var invitation: Invitation? = null,
    private var ticket: Ticket? = null

) {

    fun hasTicket(): Boolean {
        return ticket != null
    }

    fun hold(ticket: Ticket): Long {
        if (hasInvitation()) {
            this.ticket = ticket
            return 0L
        }
        this.ticket = ticket
        minusAmount(ticket.fee)
        return ticket.fee
    }

    private fun hasInvitation(): Boolean {
        return invitation != null
    }

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }
}