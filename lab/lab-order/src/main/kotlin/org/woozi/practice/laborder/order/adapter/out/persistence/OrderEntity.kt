package org.woozi.practice.laborder.order.adapter.out.persistence

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "ORDERS")
class OrderEntity(

    @Column(name = "USER_ID")
    var userId: Long,

    @Column(name = "SHOP_ID")
    var shopId: Long,

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "ORDER_ID")
    val orderLineItems: MutableList<OrderLineItemEntity> = mutableListOf(),

    @Column(name = "ORDERED_TIME")
    var orderedTime: LocalDateTime,

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    var orderStatus: OrderStatus,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    var id: Long? = null,
) {
}