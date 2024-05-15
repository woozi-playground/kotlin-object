data class Theater(
    private val ticketSeller: TicketSeller
) {
    fun enter(audience: Audience): Theater =
        Theater(ticketSeller.sellTo(audience))
}