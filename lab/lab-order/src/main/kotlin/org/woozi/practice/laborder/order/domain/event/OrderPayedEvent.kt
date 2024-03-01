package org.woozi.practice.laborder.order.domain.event

import org.woozi.practice.laborder.order.domain.Order

data class OrderPayedEvent(private val order: Order) {
    fun orderId(): Long = order.id
}