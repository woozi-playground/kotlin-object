package org.woozi.practice.laborder.shop.adapter.out.persistence

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "MENUS")
class MenuEntity(

    @Column(name = "FOOD_NAME")
    var name: String,

    @Column(name = "FOOD_DESCRIPTION")
    var description: String,

    @Column(name = "SHOP_ID")
    var shopId: Long,

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "MENU_ID")
    var optionGroupSpecs: MutableList<OptionGroupSpecificationEntity> = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MENU_ID")
    var id: Long? = null
)