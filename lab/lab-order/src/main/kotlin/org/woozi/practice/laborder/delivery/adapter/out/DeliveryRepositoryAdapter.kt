package org.woozi.practice.laborder.delivery.adapter.out

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import org.woozi.practice.laborder.delivery.adapter.out.persistence.DeliveryEntity
import org.woozi.practice.laborder.delivery.adapter.out.persistence.DeliveryEntityRepository
import org.woozi.practice.laborder.delivery.application.port.DeliveryRepository
import org.woozi.practice.laborder.delivery.domain.Delivery

@Component
class DeliveryRepositoryAdapter(
    private val deliveryEntityRepository: DeliveryEntityRepository
) : DeliveryRepository {

    @Transactional(readOnly = false)
    override fun save(delivery: Delivery) {
        DeliveryEntity(
            orderId = delivery.orderId,
            deliveryStatus = delivery.deliveryStatus
        ).let {
            deliveryEntityRepository.save(it)
        }
    }

    override fun findByOrderId(orderId: Long): Delivery =
        deliveryEntityRepository.findByOrderId(orderId).let {
            Delivery(
                orderId = it.orderId,
                deliveryStatus = it.deliveryStatus
            )
        }
}