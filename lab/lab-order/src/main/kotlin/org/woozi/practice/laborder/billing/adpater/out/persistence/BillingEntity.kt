package org.woozi.practice.laborder.billing.adpater.out.persistence

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "BILLINGS")
class BillingEntity(

    @Column(name = "SHOP_ID")
    var shopId: Long,

    @Column(name = "COMMISSION")
    var commission: Long,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BILLING_ID")
    var id: Long? = null
)