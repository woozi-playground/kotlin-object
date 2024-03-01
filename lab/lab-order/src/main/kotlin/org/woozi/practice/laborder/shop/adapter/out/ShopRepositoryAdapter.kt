package org.woozi.practice.laborder.shop.adapter.out

import jakarta.persistence.EntityNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.woozi.practice.laborder.common.Money
import org.woozi.practice.laborder.common.Ratio
import org.woozi.practice.laborder.shop.adapter.out.persistence.ShopEntity
import org.woozi.practice.laborder.shop.adapter.out.persistence.ShopEntityRepository
import org.woozi.practice.laborder.shop.application.port.out.ShopRepository
import org.woozi.practice.laborder.shop.domain.Shop

@Component
class ShopRepositoryAdapter(
    private val shopEntityRepository: ShopEntityRepository
) : ShopRepository {

    override fun findById(shopId: Long): Shop {
        return shopEntityRepository.findByIdOrNull(shopId)
            ?.let(::mapper)
            ?: throw EntityNotFoundException("Not found shop with id: $shopId")
    }

    private fun mapper(shopEntity: ShopEntity): Shop = Shop(
        id = shopEntity.id!!,
        name = shopEntity.name,
        open = shopEntity.open,
        minOrderAmount = Money(shopEntity.minOrderAmount),
        commissionRate = Ratio(shopEntity.commissionRate),
    )
}