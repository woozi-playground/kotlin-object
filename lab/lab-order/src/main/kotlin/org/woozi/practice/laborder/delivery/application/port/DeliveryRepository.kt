package org.woozi.practice.laborder.delivery.application.port

import org.woozi.practice.laborder.delivery.domain.Delivery

interface DeliveryRepository {
    fun save(delivery: Delivery)
    fun findByOrderId(orderId: Long): Delivery
}