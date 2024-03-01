package org.woozi.practice.laborder.delivery.application

import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.woozi.practice.laborder.delivery.application.port.DeliveryRepository
import org.woozi.practice.laborder.delivery.domain.Delivery
import org.woozi.practice.laborder.order.domain.event.OrderDeliveredEvent

@Component
class CompleteDeliveryWithOrderDeliveredEventHandler(private val deliveryRepository: DeliveryRepository) {
    @Async
    @EventListener
    fun handle(event: OrderDeliveredEvent) {
        val delivery: Delivery = deliveryRepository.findByOrderId(event.orderId)
        deliveryRepository.save(delivery.complete())
    }
}