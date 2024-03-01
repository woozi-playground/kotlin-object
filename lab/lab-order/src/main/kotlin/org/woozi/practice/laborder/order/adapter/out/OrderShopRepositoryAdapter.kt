package org.woozi.practice.laborder.order.adapter.out

import org.springframework.stereotype.Component
import org.woozi.practice.laborder.order.adapter.out.http.MenuClient
import org.woozi.practice.laborder.order.adapter.out.http.ShopClient
import org.woozi.practice.laborder.order.application.port.out.OrderShopRepository
import org.woozi.practice.laborder.order.domain.Order
import org.woozi.practice.laborder.order.domain.OrderShop

@Component
class OrderShopRepositoryAdapter(
    private val shopClient: ShopClient,
): OrderShopRepository {
    override fun findById(shopId: Long): OrderShop =
        shopClient.findById(shopId).toOrderShop()
}
