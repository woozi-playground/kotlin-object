package org.woozi.practice.laborder.order.application.port.out

import org.woozi.practice.laborder.order.domain.Order
import org.woozi.practice.laborder.order.domain.OrderRequest

interface OrderRepository {
    fun save(order: OrderRequest): Order
}