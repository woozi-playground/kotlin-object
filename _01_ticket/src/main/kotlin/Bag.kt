data class Bag(
    private val amount: Long = 0L,
    private val invitation: Invitation? = null,
    private var ticket: Ticket? = null
) {

    fun hold(ticket: Ticket): Long {
        if (hasInvitation()) {
            setTicket(ticket)
            return 0L
        }
        minusAmount(ticket.fee)
        setTicket(ticket)
        return ticket.fee
    }

    private fun hasInvitation(): Boolean = invitation != null

    private fun minusAmount(amount: Long): Bag =
        Bag(this.amount - amount, invitation, ticket)

    private fun setTicket(ticket: Ticket) {
        this.ticket = ticket
    }
}