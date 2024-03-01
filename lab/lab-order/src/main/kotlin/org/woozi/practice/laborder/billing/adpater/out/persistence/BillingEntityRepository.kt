package org.woozi.practice.laborder.billing.adpater.out.persistence

import org.springframework.data.jpa.repository.JpaRepository

interface BillingEntityRepository: JpaRepository<BillingEntity,  Long> {
    fun findByShopId(shopId: Long): BillingEntity?
}