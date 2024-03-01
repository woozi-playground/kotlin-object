package org.woozi.practice.laborder.delivery.adapter.out.persistence

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.woozi.practice.laborder.delivery.domain.DeliveryStatus

@Entity
@Table(name = "DELIVERIES")
class DeliveryEntity(

    @Column(name = "ORDER_ID")
    var orderId: Long,

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    var deliveryStatus: DeliveryStatus,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DELIVERY_ID")
    var id: Long? = null,
)
