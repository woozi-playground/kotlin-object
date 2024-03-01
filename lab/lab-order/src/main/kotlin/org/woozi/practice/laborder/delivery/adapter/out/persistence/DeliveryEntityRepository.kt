package org.woozi.practice.laborder.delivery.adapter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository

interface DeliveryEntityRepository : JpaRepository<DeliveryEntity, Long> {
    fun findByOrderId(orderId: Long): DeliveryEntity
}