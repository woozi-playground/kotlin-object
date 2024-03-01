package org.woozi.practice.laborder.order.adapter.out.persistence

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
class OrderOptionEntity(
    @Column(name = "NAME")
    var name: String,

    @Column(name = "PRICE")
    var price: Long,
)