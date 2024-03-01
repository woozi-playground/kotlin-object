package org.woozi.practice.laborder.order.application.port.`in`

import org.woozi.practice.laborder.order.domain.OrderRequest

data class OrderRequestCommand(
    val userId: Long,
    val shopId: Long,
) {
    fun toOrderRequest(): OrderRequest =
        OrderRequest(userId, shopId, listOf())
}
