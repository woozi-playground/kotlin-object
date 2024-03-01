package org.woozi.practice.laborder.order.domain

import org.woozi.practice.laborder.common.Money
import org.woozi.practice.laborder.shop.domain.Option

data class OrderOptionRequest(
    val name: String,
    val price: Money
)