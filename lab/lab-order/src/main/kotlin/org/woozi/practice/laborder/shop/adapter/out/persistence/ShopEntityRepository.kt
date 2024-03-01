package org.woozi.practice.laborder.shop.adapter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository

interface ShopEntityRepository : JpaRepository<ShopEntity, Long>