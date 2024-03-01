package org.woozi.practice.laborder.shop.application.port.out

import org.woozi.practice.laborder.shop.domain.Shop

interface ShopRepository {
    fun findById(shopId: Long): Shop
}