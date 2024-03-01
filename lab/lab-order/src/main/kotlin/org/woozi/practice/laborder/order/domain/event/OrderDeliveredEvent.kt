package org.woozi.practice.laborder.order.domain.event

import org.woozi.practice.laborder.common.Money
import org.woozi.practice.laborder.order.domain.Order

class OrderDeliveredEvent(private val order: Order) {
    val orderId: Long
        get() = order.id

    val shopId: Long
        get() = order.shopId

    val totalPrice: Money
        get() = order.calculateTotalPrice()
}