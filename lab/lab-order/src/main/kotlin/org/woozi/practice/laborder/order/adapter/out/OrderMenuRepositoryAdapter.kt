package org.woozi.practice.laborder.order.adapter.out

import org.springframework.stereotype.Component
import org.woozi.practice.laborder.order.adapter.out.http.MenuClient
import org.woozi.practice.laborder.order.adapter.out.http.MenuResponse
import org.woozi.practice.laborder.order.adapter.out.http.ShopClient
import org.woozi.practice.laborder.order.application.port.out.OrderMenuRepository
import org.woozi.practice.laborder.order.domain.Order
import org.woozi.practice.laborder.order.domain.OrderMenu

@Component
class OrderMenuRepositoryAdapter(
    private val menuClient: MenuClient,
): OrderMenuRepository {

    override fun findAllById(menuIds: List<Long>): List<OrderMenu> =
        menuClient.getByIds(menuIds).map(MenuResponse::toOrderMenu)
}
