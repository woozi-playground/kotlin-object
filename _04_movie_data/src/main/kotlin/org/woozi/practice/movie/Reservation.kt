package org.woozi.practice.movie

data class Reservation(
    var customer: Customer,
    var screening: Screening,
    var fee: Money,
    var audienceCount: Int
)
