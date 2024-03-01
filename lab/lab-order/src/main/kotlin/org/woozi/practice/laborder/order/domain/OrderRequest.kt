package org.woozi.practice.laborder.order.domain

import org.woozi.practice.laborder.order.application.service.OrderValidateService

class OrderRequest(
    val userId: Long,
    val shopId: Long,
    val orderLineItems: List<OrderLineItemRequest>
) {
    fun validate(orderValidateService: OrderValidateService) {
        orderValidateService.validate(this)
    }

    fun menuIds(): List<Long> = orderLineItems.map(OrderLineItemRequest::menuId)
}