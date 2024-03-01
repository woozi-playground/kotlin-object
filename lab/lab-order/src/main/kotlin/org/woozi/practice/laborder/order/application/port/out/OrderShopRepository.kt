package org.woozi.practice.laborder.order.application.port.out

import org.woozi.practice.laborder.order.domain.OrderShop

interface OrderShopRepository {
    fun findById(shopId: Long): OrderShop
}