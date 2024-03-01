package org.woozi.practice.laborder.order.domain

data class OrderOptionGroupRequest(
    val name: String,
    val orderOptions: List<OrderOptionRequest>
)

