package org.woozi.practice.laborder.delivery.domain

import org.woozi.practice.laborder.delivery.adapter.out.persistence.DeliveryStatus

data class Delivery(
    val orderId: Long,
    val deliveryStatus: DeliveryStatus = DeliveryStatus.DELIVERING
) {
    fun complete(): Delivery =
        Delivery(orderId, DeliveryStatus.DELIVERED)
}