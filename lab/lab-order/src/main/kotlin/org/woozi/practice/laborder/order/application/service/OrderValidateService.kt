package org.woozi.practice.laborder.order.application.service

import org.springframework.stereotype.Service
import org.woozi.practice.laborder.order.application.port.out.OrderMenuRepository
import org.woozi.practice.laborder.order.application.port.out.OrderShopRepository
import org.woozi.practice.laborder.order.domain.OrderRequest

@Service
class OrderValidateService(
    private val orderShopRepository: OrderShopRepository,
    private val orderMenuRepository: OrderMenuRepository,
) {
    fun validate(orderRequest: OrderRequest) {
        val orderShop = orderShopRepository.findById(orderRequest.shopId)
        orderShop.validate(orderRequest)

        val orderMenuList = orderMenuRepository.findAllById(orderRequest.menuIds())
        orderMenuList.forEach { it.validate(orderRequest) }
    }
}