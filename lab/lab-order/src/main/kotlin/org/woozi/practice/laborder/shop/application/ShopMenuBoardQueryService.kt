package org.woozi.practice.laborder.shop.application

import org.springframework.stereotype.Service
import org.woozi.practice.laborder.shop.application.port.out.MenuRepository
import org.woozi.practice.laborder.shop.application.port.out.ShopRepository
import org.woozi.practice.laborder.shop.domain.MenuBoard

@Service
class ShopMenuBoardQueryService(
    private val shopRepository: ShopRepository,
    private val menuRepository: MenuRepository
) {

    fun findMenuBoard(shopId: Long): MenuBoard {
        val shop = shopRepository.findById(shopId)
        val menus = menuRepository.findByShopId(shopId)
        return MenuBoard(shop, menus)
    }
}
