package org.woozi.practice.laborder.order.domain

data class OrderLineItemRequest(
    val menuId: Long,
    val name: String,
    val count: Int = 0,
    val groups: List<OrderOptionGroupRequest>
)