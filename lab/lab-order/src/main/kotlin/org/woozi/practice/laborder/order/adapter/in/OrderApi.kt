package org.woozi.practice.laborder.order.adapter.`in`

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.woozi.practice.laborder.order.application.OrderRequestUseCase

@RestController
class OrderApi(
    private val orderRequestUseCase: OrderRequestUseCase
) {

    @PostMapping("/order")
    fun test(@RequestBody request: OrderHttpRequest) {
        orderRequestUseCase.requestOrder(request.toCommand())
    }
}