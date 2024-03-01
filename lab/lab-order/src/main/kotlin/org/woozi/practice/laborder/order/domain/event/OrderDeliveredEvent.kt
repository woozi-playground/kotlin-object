package org.woozi.practice.laborder.order.domain.event

import org.woozi.practice.laborder.common.Money
import org.woozi.practice.laborder.order.domain.Order

class OrderDeliveredEvent(
    val orderId: Long,
    val shopId: Long,
    val totalPrice: Money
) {
    constructor(order: Order) : this(order.id!!, order.shopId, order.calculateTotalPrice())
}