package org.woozi.practice.laborder.order.application.service

import org.springframework.stereotype.Service
import org.woozi.practice.laborder.order.application.port.out.OrderMenuRepository
import org.woozi.practice.laborder.order.application.port.out.OrderShopRepository
import org.woozi.practice.laborder.order.domain.Order

@Service
class OrderValidateService(
    private val orderShopRepository: OrderShopRepository,
    private val orderMenuRepository: OrderMenuRepository,
) {
    fun validate(order: Order) {
        val orderShop = orderShopRepository.findById(order.shopId)
        orderShop.validate(order)
        val orderMenuList = orderMenuRepository.findAllById(order.menuIds())
        orderMenuList.forEach { it.validate(order) }
    }
}