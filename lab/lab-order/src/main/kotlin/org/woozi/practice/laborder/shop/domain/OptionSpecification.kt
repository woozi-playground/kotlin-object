package org.woozi.practice.laborder.shop.domain

import org.woozi.practice.laborder.common.Money

data class OptionSpecification(
    val id: Long,
    val name: String,
    val price: Money
) {

    fun isSatisfiedBy(option: Option): Boolean =
        name == option.name && price == option.price
}
