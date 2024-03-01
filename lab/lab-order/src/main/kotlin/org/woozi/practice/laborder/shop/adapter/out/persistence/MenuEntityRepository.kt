package org.woozi.practice.laborder.shop.adapter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository

interface MenuEntityRepository : JpaRepository<MenuEntity, Long> {
    fun findByShopId(shopId: Long): List<MenuEntity>
}
