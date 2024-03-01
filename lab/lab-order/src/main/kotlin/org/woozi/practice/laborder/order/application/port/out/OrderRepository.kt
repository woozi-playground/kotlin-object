package org.woozi.practice.laborder.order.application.port.out

import org.woozi.practice.laborder.order.domain.Order

interface OrderRepository {
    fun save(order: Order)
}