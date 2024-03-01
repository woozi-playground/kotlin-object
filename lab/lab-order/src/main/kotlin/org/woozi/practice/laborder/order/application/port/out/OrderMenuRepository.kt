package org.woozi.practice.laborder.order.application.port.out

import org.woozi.practice.laborder.order.domain.OrderMenu

interface OrderMenuRepository {
    fun findAllById(menuIds: List<Long>): List<OrderMenu>
}