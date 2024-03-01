package org.woozi.practice.laborder.order.domain

import org.woozi.practice.laborder.common.Money
import org.woozi.practice.laborder.shop.domain.OptionGroup

data class OrderOptionGroup(
    val id: Long,
    val name: String,
    val orderOptions: List<OrderOption>
) {
    fun calculatePrice(): Money =
        Money.sum(orderOptions, OrderOption::price)

    fun convertToOptionGroup(): OptionGroup =
        OptionGroup(name, orderOptions.map(OrderOption::convertToOption))
}

