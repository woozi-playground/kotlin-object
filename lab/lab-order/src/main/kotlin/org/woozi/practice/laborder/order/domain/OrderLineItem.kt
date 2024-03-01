package org.woozi.practice.laborder.order.domain

import org.woozi.practice.laborder.common.Money

class OrderLineItem(
    val id: Long,
    val menuId: Long,
    val name: String,
    val count: Int = 0,
    val groups: List<OrderOptionGroup>
) {
    fun calculatePrice(): Money {
        return Money.sum(groups, OrderOptionGroup::calculatePrice).times(count)
    }
}
