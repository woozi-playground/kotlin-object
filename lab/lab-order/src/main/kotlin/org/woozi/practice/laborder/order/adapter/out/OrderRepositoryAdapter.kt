package org.woozi.practice.laborder.order.adapter.out

import org.springframework.stereotype.Component
import org.woozi.practice.laborder.order.adapter.out.persistence.OrderEntityRepository
import org.woozi.practice.laborder.order.application.port.out.OrderRepository
import org.woozi.practice.laborder.order.domain.Order

@Component
class OrderRepositoryAdapter(
    private val orderRepository: OrderEntityRepository
) : OrderRepository {

    override fun save(order: Order) {
        order
    }
}
