package org.woozi.practice.laborder.shop.domain

import org.woozi.practice.laborder.common.Money

data class Option(
    val name: String,
    val price: Money,
)