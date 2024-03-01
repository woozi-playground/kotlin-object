package org.woozi.practice.laborder.shop.domain

import org.woozi.practice.laborder.common.Money

class MenuBoard(
    private val shopId: Long,
    private val shopName: String,
    private val open: Boolean,
    private val minOrderAmount: Money,
    private val menuItems: List<MenuItem>,
) {
    constructor(shop: Shop, menuItems: List<Menu>) : this(
        shop.id,
        shop.name,
        shop.open,
        shop.minOrderAmount,
        menuItems.map(::MenuItem)
    )

    class MenuItem(menu: Menu) {
        private val menuId: Long
        private val menuName: String
        private val menuBasePrice: Money
        private val menuDescription: String

        init {
            this.menuId = menu.id
            this.menuName = menu.name
            this.menuBasePrice = menu.getBasePrice()
            this.menuDescription = menu.description
        }
    }
}