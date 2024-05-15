package org.woozi.practice.movie

class TicketOffice(
    private var amount: Long,
    private var tickets: MutableList<Ticket> = mutableListOf()
) {

    val ticket: Ticket
        get() = tickets.removeFirst()

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }
}