package org.woozi.practice.movie


fun main() {
    val audience = Audience(Bag(10_000))
    val ticketOffice = TicketOffice(0, mutableListOf(Ticket(1000), Ticket(1000)))
    val ticketSeller = TicketSeller(ticketOffice)
    ticketSeller.sellTo(audience)

    // val audience = Audience(Bag(10_000, Invitation(LocalDateTime.now())))
    // val ticketOffice = TicketOffice(0, mutableListOf(Ticket(1000), Ticket(1000)))
    // val ticketSeller = TicketSeller(ticketOffice)
    // ticketSeller.sellTo(audience)

    println(audience)
}
