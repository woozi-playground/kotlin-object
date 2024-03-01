package org.woozi.practice.laborder.order.adapter.out.persistence

import jakarta.persistence.CollectionTable
import jakarta.persistence.Column
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Table

@Entity
@Table(name = "ORDER_OPTION_GROUPS")
class OrderOptionGroupEntity(

    @Column(name = "NAME")
    var name: String,

    @ElementCollection
    @CollectionTable(name = "ORDER_OPTIONS", joinColumns = [JoinColumn(name = "ORDER_OPTION_GROUP_ID")])
    var orderOptions: MutableList<OrderOptionEntity> = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_OPTION_GROUP_ID")
    var id: Long? = null,
)