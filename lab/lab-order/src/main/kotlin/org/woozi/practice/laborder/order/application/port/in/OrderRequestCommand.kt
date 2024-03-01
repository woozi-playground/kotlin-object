package org.woozi.practice.laborder.order.application.port.`in`

import org.woozi.practice.laborder.order.domain.Order

data class OrderRequestCommand(
    val shopId: Long,
    val menuId: String,
    val quantity: Int
) {
    fun toOrder(): Order =
        Order(shopId, listOf())
}