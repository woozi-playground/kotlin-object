package org.woozi.practice.laborder.order.domain

import org.woozi.practice.laborder.common.Money
import org.woozi.practice.laborder.order.application.service.OrderValidateService

data class Order(
    val id: Long,
    val shopId: Long,
    val orderLineItems: List<OrderLineItem>

) {
    fun validate(orderValidateService: OrderValidateService) {
        orderValidateService.validate(this)
    }

    fun menuIds(): List<Long> =
        orderLineItems.map(OrderLineItem::menuId)

    fun calculateTotalPrice(): Money {
        return Money.sum(orderLineItems, OrderLineItem::calculatePrice);
    }
}
