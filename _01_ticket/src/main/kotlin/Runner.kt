class Runner

fun main() {
    val audience = Audience(Bag(100L))
    val theater = Theater(TicketSeller(TicketOffice(0L, mutableListOf(Ticket(100L), Ticket(100L)))))

    theater.enter(audience)
}