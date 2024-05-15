package org.woozi.practice.movie

class Audience(private val bag: Bag) {

    fun buy(ticket: Ticket): Long =
        bag.hold(ticket)
}