data class TicketOffice(
    private val amount: Long,
    private val tickets: MutableList<Ticket> = mutableListOf()
) {
    fun sellTicketTo(audience: Audience): TicketOffice =
        plusAmount(audience.buy(getTicket()))

    fun plusAmount(amount: Long): TicketOffice =
        TicketOffice(this.amount + amount, tickets)

    fun getTicket(): Ticket =
        tickets.removeAt(0)
}