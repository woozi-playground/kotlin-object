package org.woozi.practice.laborder.delivery.domain

data class Delivery(
    val orderId: Long,
    val deliveryStatus: DeliveryStatus = DeliveryStatus.DELIVERING
) {
    fun complete(): Delivery =
        Delivery(orderId, DeliveryStatus.DELIVERED)
}