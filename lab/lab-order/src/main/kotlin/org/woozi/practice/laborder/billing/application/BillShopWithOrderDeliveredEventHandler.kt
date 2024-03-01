package org.woozi.practice.laborder.billing.application

import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.woozi.practice.laborder.billing.application.port.out.BillingRepository
import org.woozi.practice.laborder.billing.application.port.out.BillingShopRepository
import org.woozi.practice.laborder.order.domain.event.OrderDeliveredEvent

@Component
class BillShopWithOrderDeliveredEventHandler(
    private val billingShopRepository: BillingShopRepository,
    private val billingRepository: BillingRepository
) {

    @Async
    @EventListener
    fun handle(event: OrderDeliveredEvent) {
        val billingShop = billingShopRepository.findByShopId(event.shopId)
        val billing = billingRepository.findByShopIdOrCreate(event.shopId)
        billing.billCommissionFee(billingShop.calculateCommissionFee(event.totalPrice))
    }
}
