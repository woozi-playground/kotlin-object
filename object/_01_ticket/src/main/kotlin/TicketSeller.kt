data class TicketSeller(
    private val ticketOffice: TicketOffice
) {
    fun sellTo(audience: Audience): TicketSeller =
        TicketSeller(ticketOffice.sellTicketTo(audience))
}