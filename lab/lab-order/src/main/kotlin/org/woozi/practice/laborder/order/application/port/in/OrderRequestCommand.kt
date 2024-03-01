package org.woozi.practice.laborder.order.application.port.`in`

import org.woozi.practice.laborder.order.domain.OrderLineItemRequest
import org.woozi.practice.laborder.order.domain.OrderRequest

data class OrderRequestCommand(
    val userId: Long,
    val shopId: Long,
    val orderLineItems: List<OrderLineItemRequest>
) {
    fun toOrderRequest(): OrderRequest =
        OrderRequest(userId, shopId, orderLineItems)
}
