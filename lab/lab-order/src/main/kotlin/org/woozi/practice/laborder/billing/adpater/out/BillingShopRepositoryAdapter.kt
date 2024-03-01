package org.woozi.practice.laborder.billing.adpater.out

import org.springframework.stereotype.Component
import org.woozi.practice.laborder.billing.adpater.out.http.BillingShopClient
import org.woozi.practice.laborder.billing.application.port.out.BillingShopRepository
import org.woozi.practice.laborder.billing.domain.BillingShop
import org.woozi.practice.laborder.common.Ratio

@Component
class BillingShopRepositoryAdapter(
    private val billingShopClient: BillingShopClient
) : BillingShopRepository {
    override fun findByShopId(shopId: Long): BillingShop =
        BillingShop(shopId, Ratio(billingShopClient.findByShopId(shopId).commissionRate))
}
