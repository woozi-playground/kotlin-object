package org.woozi.practice.laborder.order.adapter.out.persistence

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "ORDER_LINE_ITEMS")
class OrderLineItemEntity(

    @Column(name = "MENU_ID")
    var menuId: Long,

    @Column(name = "FOOD_NAME")
    var name: String,

    @Column(name = "FOOD_COUNT")
    var count: Int,

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "ORDER_LINE_ITEM_ID")
    val groups: MutableList<OrderOptionGroupEntity> = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_LINE_ITEM_ID")
    var id: Long? = null
)