package org.woozi.practice.laborder.shop.adapter.out

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import org.woozi.practice.laborder.common.Money
import org.woozi.practice.laborder.shop.adapter.out.persistence.MenuEntityRepository
import org.woozi.practice.laborder.shop.adapter.out.persistence.OptionGroupSpecificationEntity
import org.woozi.practice.laborder.shop.adapter.out.persistence.OptionSpecificationEntity
import org.woozi.practice.laborder.shop.application.port.out.MenuRepository
import org.woozi.practice.laborder.shop.domain.Menu
import org.woozi.practice.laborder.shop.domain.OptionGroupSpecification
import org.woozi.practice.laborder.shop.domain.OptionSpecification

@Component
class MenuRepositoryAdapter(
    private val menuEntityRepository: MenuEntityRepository
) : MenuRepository {

    @Transactional(readOnly = true)
    override fun findByShopId(shopId: Long): List<Menu> = menuEntityRepository.findByShopId(shopId)
        .map { Menu(it.id!!, it.name, it.description, it.shopId, mapToOptionGroupSpecs(it.optionGroupSpecs)) }

    private fun mapToOptionGroupSpecs(optionGroupSpecs: MutableList<OptionGroupSpecificationEntity>): List<OptionGroupSpecification> =
        optionGroupSpecs.map {
            OptionGroupSpecification(
                it.id!!,
                it.name,
                it.exclusive,
                it.basic,
                mapToOptionSpecs(it.optionSpecs)
            )
        }

    private fun mapToOptionSpecs(optionSpecs: MutableList<OptionSpecificationEntity>): List<OptionSpecification> =
        optionSpecs.map { OptionSpecification(it.id!!, it.name, Money(it.price)) }
}
