package org.woozi.practice.laborder.billing.domain

import org.woozi.practice.laborder.common.Money

class Billing(
    val id: Long,
    val shopId: Long,
    private val commission: Money = Money.ZERO
) {
    fun billCommissionFee(commission: Money): Billing =
        Billing(id, shopId, this.commission.plus(commission))
}
