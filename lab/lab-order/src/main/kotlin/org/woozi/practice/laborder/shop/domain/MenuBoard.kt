package org.woozi.practice.laborder.shop.domain

import org.woozi.practice.laborder.common.Money

data class MenuBoard(
    val shopId: Long,
    val shopName: String,
    val open: Boolean,
    val minOrderAmount: Money,
    val menuItems: List<MenuItem>,
) {
    constructor(shop: Shop, menuItems: List<Menu>) : this(
        shop.id,
        shop.name,
        shop.open,
        shop.minOrderAmount,
        menuItems.map(::MenuItem)
    )

    data class MenuItem(
        val menuId: Long,
        val menuName: String,
        val menuBasePrice: Money,
        val menuDescription: String
    ) {
        constructor(menu: Menu) : this(menu.id, menu.name, menu.getBasePrice(), menu.description)
    }
}
