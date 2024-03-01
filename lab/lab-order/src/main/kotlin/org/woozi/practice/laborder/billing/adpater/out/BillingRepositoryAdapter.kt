package org.woozi.practice.laborder.billing.adpater.out

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import org.woozi.practice.laborder.billing.adpater.out.persistence.BillingEntity
import org.woozi.practice.laborder.billing.adpater.out.persistence.BillingEntityRepository
import org.woozi.practice.laborder.billing.application.port.out.BillingRepository
import org.woozi.practice.laborder.billing.domain.Billing
import org.woozi.practice.laborder.common.Money

@Component
class BillingRepositoryAdapter(
    private val billingEntityRepository: BillingEntityRepository
) : BillingRepository {

    @Transactional(readOnly = false)
    override fun findByShopIdOrCreate(shopId: Long): Billing =
        billingEntityRepository.findByShopId(shopId)?.let {
            Billing(it.id!!, it.shopId, Money(it.commission))
        } ?: billingEntityRepository.save(BillingEntity(shopId = shopId, commission = 0)).let {
            Billing(it.id!!, it.shopId, Money(it.commission))
        }
}
