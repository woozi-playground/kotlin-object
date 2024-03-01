package org.woozi.practice.laborder.order.adapter.out.http

import org.woozi.practice.laborder.order.domain.OrderMenu

class MenuResponse {

    fun toOrderMenu(): OrderMenu {
        return OrderMenu()
    }
}