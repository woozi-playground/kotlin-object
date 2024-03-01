package org.woozi.practice.laborder.order.adapter.out

import org.springframework.stereotype.Component
import org.woozi.practice.laborder.common.Money
import org.woozi.practice.laborder.order.adapter.out.persistence.OrderEntity
import org.woozi.practice.laborder.order.adapter.out.persistence.OrderEntityRepository
import org.woozi.practice.laborder.order.adapter.out.persistence.OrderLineItemEntity
import org.woozi.practice.laborder.order.adapter.out.persistence.OrderOptionEntity
import org.woozi.practice.laborder.order.adapter.out.persistence.OrderOptionGroupEntity
import org.woozi.practice.laborder.order.adapter.out.persistence.OrderStatus
import org.woozi.practice.laborder.order.application.port.out.OrderRepository
import org.woozi.practice.laborder.order.domain.Order
import org.woozi.practice.laborder.order.domain.OrderLineItem
import org.woozi.practice.laborder.order.domain.OrderLineItemRequest
import org.woozi.practice.laborder.order.domain.OrderOption
import org.woozi.practice.laborder.order.domain.OrderOptionGroup
import org.woozi.practice.laborder.order.domain.OrderOptionGroupRequest
import org.woozi.practice.laborder.order.domain.OrderOptionRequest
import org.woozi.practice.laborder.order.domain.OrderRequest
import java.time.ZonedDateTime

@Component
class OrderRepositoryAdapter(
    private val orderRepository: OrderEntityRepository
) : OrderRepository {

    override fun save(orderRequest: OrderRequest): Order {
        val orderEntity = orderRepository.save(createOrderEntity(orderRequest))
        return Order(orderEntity.id!!, orderEntity.userId, orderEntity.shopId, orderLineItems(orderEntity.orderLineItems), orderEntity.orderedTime, orderEntity.orderStatus)
    }

    private fun createOrderEntity(orderRequest: OrderRequest) = OrderEntity(
        userId = orderRequest.userId,
        shopId = orderRequest.shopId,
        orderLineItems = orderLineItemEntities(orderRequest.orderLineItems),
        orderedTime = ZonedDateTime.now().toLocalDateTime(),
        orderStatus = OrderStatus.ORDERED
    )

    private fun orderLineItemEntities(orderLineItems: List<OrderLineItemRequest>): MutableList<OrderLineItemEntity> =
        orderLineItems.map {
            OrderLineItemEntity(
                menuId = it.menuId,
                name = it.name,
                count = it.count,
                groups = orderOptionGroupEntities(it.groups)
            )
        }.toMutableList()

    private fun orderOptionGroupEntities(groups: List<OrderOptionGroupRequest>): MutableList<OrderOptionGroupEntity> =
        groups.map {
            OrderOptionGroupEntity(name = it.name, orderOptions = orderOptionEntities(it.orderOptions))
        }.toMutableList()

    private fun orderOptionEntities(orderOptions: List<OrderOptionRequest>): MutableList<OrderOptionEntity> =
        orderOptions.map { OrderOptionEntity(name = it.name, price = it.price.amount) }.toMutableList()


    private fun orderLineItems(orderLineItems: MutableList<OrderLineItemEntity>): List<OrderLineItem> =
        orderLineItems.map { OrderLineItem(it.id!!, it.menuId, it.name, it.count, orderOptionGroup(it.groups) ) }

    private fun orderOptionGroup(groups: MutableList<OrderOptionGroupEntity>): List<OrderOptionGroup> =
        groups.map { OrderOptionGroup(it.id!!, it.name, orderOptions(it.orderOptions)) }

    private fun orderOptions(orderOptions: MutableList<OrderOptionEntity>): List<OrderOption> =
        orderOptions.map { OrderOption(it.name, Money(it.price)) }
}
