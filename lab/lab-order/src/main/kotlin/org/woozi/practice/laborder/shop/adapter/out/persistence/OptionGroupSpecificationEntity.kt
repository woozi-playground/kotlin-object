package org.woozi.practice.laborder.shop.adapter.out.persistence

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "OPTION_GROUP_SPECS")
class OptionGroupSpecificationEntity(

    @Column(name = "NAME")
    var name: String,

    @Column(name = "EXCLUSIVE")
    var exclusive: Boolean,

    @Column(name = "BASIC")
    var basic: Boolean,

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "OPTION_GROUP_SPEC_ID")
    var optionSpecs: MutableList<OptionSpecificationEntity> = mutableListOf(),

    @Id
    @GeneratedValue
    @Column(name = "OPTION_GROUP_SPEC_ID")
    var id: Long? = null
)