package org.woozi.practice.laborder.order.adapter.out

import org.springframework.stereotype.Component
import org.woozi.practice.laborder.order.adapter.out.persistence.OrderEntity
import org.woozi.practice.laborder.order.adapter.out.persistence.OrderEntityRepository
import org.woozi.practice.laborder.order.adapter.out.persistence.OrderLineItemEntity
import org.woozi.practice.laborder.order.adapter.out.persistence.OrderOptionEntity
import org.woozi.practice.laborder.order.adapter.out.persistence.OrderOptionGroupEntity
import org.woozi.practice.laborder.order.adapter.out.persistence.OrderStatus
import org.woozi.practice.laborder.order.application.port.out.OrderRepository
import org.woozi.practice.laborder.order.domain.OrderLineItem
import org.woozi.practice.laborder.order.domain.OrderOption
import org.woozi.practice.laborder.order.domain.OrderOptionGroup
import org.woozi.practice.laborder.order.domain.OrderRequest
import java.time.ZonedDateTime

@Component
class OrderRepositoryAdapter(
    private val orderRepository: OrderEntityRepository
) : OrderRepository {

    override fun save(orderRequest: OrderRequest) {
        val orderEntity = createOrderEntity(orderRequest)
        orderRepository.save(orderEntity)
    }

    private fun createOrderEntity(orderRequest: OrderRequest) = OrderEntity(
        userId = orderRequest.userId,
        shopId = orderRequest.shopId,
        orderLineItems = orderLineItemEntities(orderRequest.orderLineItems),
        orderedTime = ZonedDateTime.now().toLocalDateTime(),
        orderStatus = OrderStatus.ORDERED
    )

    private fun orderLineItemEntities(orderLineItems: List<OrderLineItem>): MutableList<OrderLineItemEntity> =
        orderLineItems.map {
            OrderLineItemEntity(
                menuId = it.menuId,
                name = it.name,
                count = it.count,
                groups = orderOptionGroupEntities(it.groups)
            )
        }.toMutableList()

    private fun orderOptionGroupEntities(groups: List<OrderOptionGroup>): MutableList<OrderOptionGroupEntity> =
        groups.map {
            OrderOptionGroupEntity(name = it.name, orderOptions = orderOptionEntities(it.orderOptions))
        }.toMutableList()

    private fun orderOptionEntities(orderOptions: List<OrderOption>): MutableList<OrderOptionEntity> =
        orderOptions.map { OrderOptionEntity(name = it.name, price = it.price.amount) }.toMutableList()
}
