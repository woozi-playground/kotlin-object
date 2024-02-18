data class TicketOffice(
    private val amount: Long,
    private val tickets: MutableList<Ticket> = mutableListOf()
) {
    fun plusAmount(amount: Long): TicketOffice =
        TicketOffice(this.amount + amount, tickets)

    fun getTicket(): Ticket {
        return tickets.removeAt(0)
    }
}