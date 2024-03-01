package org.woozi.practice.laborder.billing.application.port.out

import org.woozi.practice.laborder.billing.domain.Billing

interface BillingRepository {
    fun findByShopIdOrCreate(shopId: Long): Billing
}