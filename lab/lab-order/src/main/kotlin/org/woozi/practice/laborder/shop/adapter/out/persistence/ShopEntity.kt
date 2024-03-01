package org.woozi.practice.laborder.shop.adapter.out.persistence

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "SHOPS")
class ShopEntity(

    @Column(name = "NAME")
    var name: String,

    @Column(name = "OPEN")
    var open: Boolean,

    @Column(name = "MIN_ORDER_AMOUNT")
    var minOrderAmount: Long,

    @Column(name = "COMMISSION_RATE")
    var commissionRate: Double,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHOP_ID")
    var id: Long? = null,
)