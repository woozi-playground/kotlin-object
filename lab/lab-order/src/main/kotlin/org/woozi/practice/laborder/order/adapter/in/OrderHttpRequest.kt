package org.woozi.practice.laborder.order.adapter.`in`

import org.woozi.practice.laborder.common.Money
import org.woozi.practice.laborder.order.application.port.`in`.OrderRequestCommand
import org.woozi.practice.laborder.order.domain.OrderLineItemRequest
import org.woozi.practice.laborder.order.domain.OrderOptionGroupRequest
import org.woozi.practice.laborder.order.domain.OrderOptionRequest

data class OrderHttpRequest(
    val userId: Long,
    val shopId: Long,
    val orderLineItems: List<OrderLineItemHttpRequest>
) {
    fun toCommand(): OrderRequestCommand =
        OrderRequestCommand(userId, shopId, orderLineItems.map(OrderLineItemHttpRequest::toOrderLineItemRequest))

    data class OrderLineItemHttpRequest(
        val menuId: Long,
        val name: String,
        val count: Int = 0,
        val groups: List<OrderOptionGroupHttpRequest>
    ) {
        fun toOrderLineItemRequest(): OrderLineItemRequest =
            OrderLineItemRequest(
                menuId,
                name,
                count,
                groups.map(OrderOptionGroupHttpRequest::toOrderOptionGroupRequest)
            )
    }

    data class OrderOptionGroupHttpRequest(
        val name: String,
        val options: List<OrderOptionHttpRequest>
    ) {
        fun toOrderOptionGroupRequest(): OrderOptionGroupRequest =
            OrderOptionGroupRequest(name, options.map(OrderOptionHttpRequest::toOrderOptionRequest))
    }

    data class OrderOptionHttpRequest(
        val name: String,
        val price: Long,
    ) {
        fun toOrderOptionRequest(): OrderOptionRequest =
            OrderOptionRequest(name, Money(price))
    }
}
