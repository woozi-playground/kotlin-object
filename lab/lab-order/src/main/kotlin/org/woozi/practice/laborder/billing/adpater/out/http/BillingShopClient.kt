package org.woozi.practice.laborder.billing.adpater.out.http

import org.springframework.stereotype.Component

@Component
class BillingShopClient {
    fun findByShopId(shopId: Long): BillingShopResponse {
        return BillingShopResponse(1, 0.1)
    }

}