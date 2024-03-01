package org.woozi.practice.laborder.shop.application.port.out

import org.woozi.practice.laborder.shop.domain.Menu

interface MenuRepository {
    fun findByShopId(shopId: Long): List<Menu>
}