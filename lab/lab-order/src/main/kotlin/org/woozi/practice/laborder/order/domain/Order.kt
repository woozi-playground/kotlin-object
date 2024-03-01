package org.woozi.practice.laborder.order.domain

import org.woozi.practice.laborder.common.Money
import org.woozi.practice.laborder.order.adapter.out.persistence.OrderStatus
import org.woozi.practice.laborder.order.domain.event.OrderPayedEvent
import java.time.LocalDateTime

data class Order(
    val id: Long,
    val userId: Long,
    val shopId: Long,
    val orderLineItems: List<OrderLineItem>,
    val orderedTime: LocalDateTime,
    val orderStatus: OrderStatus,
) {

    fun menuIds(): List<Long> =
        orderLineItems.map(OrderLineItem::menuId)

    fun calculateTotalPrice(): Money {
        return Money.sum(orderLineItems, OrderLineItem::calculatePrice);
    }

    fun payed(function: (OrderPayedEvent) -> Unit) {
        function.invoke(OrderPayedEvent(this))
    }
}
