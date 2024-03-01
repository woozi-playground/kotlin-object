package org.woozi.practice.laborder.order.domain

import org.woozi.practice.laborder.common.Money

data class Order(
    val shopId: Long,
    val orderLineItems: List<OrderLineItem>,
    val id: Long,
) {

    fun menuIds(): List<Long> =
        orderLineItems.map(OrderLineItem::menuId)

    fun calculateTotalPrice(): Money {
        return Money.sum(orderLineItems, OrderLineItem::calculatePrice);
    }
}
