package org.woozi.practice.laborder.shop.domain

import org.woozi.practice.laborder.common.Money

data class Menu(
    val id: Long,
    val name: String,
    val description: String,
    val shopId: Long,
    val optionGroupSpecs: List<OptionGroupSpecification>
) {

    fun getBasePrice(): Money =
        getBasicOptionGroupSpecs().optionSpecs[0].price

    private fun getBasicOptionGroupSpecs(): OptionGroupSpecification =
        optionGroupSpecs.firstOrNull(OptionGroupSpecification::basic)
            ?: throw IllegalStateException()
}
