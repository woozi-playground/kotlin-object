package org.woozi.practice.laborder.shop.domain

import org.woozi.practice.laborder.common.Money
import org.woozi.practice.laborder.common.Ratio

data class Shop(
    val id: Long,
    val name: String,
    val open: Boolean,
    val minOrderAmount: Money,
    val commissionRate: Ratio
)