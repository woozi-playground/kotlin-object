package org.woozi.practice.laborder.billing.domain

import org.woozi.practice.laborder.common.Money
import org.woozi.practice.laborder.common.Ratio

class BillingShop(
    private val shopId: Long,
    private val commissionRate: Ratio
) {
    fun calculateCommissionFee(price: Money): Money =
        commissionRate.of(price)
}