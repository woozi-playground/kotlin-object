package org.woozi.practice.laborder.order.adapter.out.http

import org.woozi.practice.laborder.order.domain.OrderShop

class ShopResponse {
    fun toOrderShop(): OrderShop = OrderShop()
}