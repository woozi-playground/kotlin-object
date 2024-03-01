package org.woozi.practice.laborder.billing.application.port.out

import org.woozi.practice.laborder.billing.domain.BillingShop

interface BillingShopRepository {
    fun findByShopId(shopId: Long): BillingShop
}