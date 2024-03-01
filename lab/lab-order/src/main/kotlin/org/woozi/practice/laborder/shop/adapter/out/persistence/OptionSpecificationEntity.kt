package org.woozi.practice.laborder.shop.adapter.out.persistence

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "OPTION_SPECS")
class OptionSpecificationEntity(

    @Column(name = "NAME")
    var name: String,

    @Column(name = "PRICE")
    var price: Long,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPTION_SPEC_ID")
    var id: Long? = null
)