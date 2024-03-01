package org.woozi.practice.laborder.order.adapter.out.http

import org.springframework.stereotype.Component

@Component
class ShopClient {
    fun findById(shopId: Long): ShopResponse =
        ShopResponse()
}