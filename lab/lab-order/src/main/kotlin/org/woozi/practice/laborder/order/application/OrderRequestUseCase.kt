package org.woozi.practice.laborder.order.application

import org.springframework.stereotype.Service
import org.woozi.practice.laborder.order.application.port.`in`.OrderRequestCommand
import org.woozi.practice.laborder.order.application.port.out.OrderRepository
import org.woozi.practice.laborder.order.application.service.OrderValidateService

@Service
class OrderRequestUseCase(
    private val orderValidateService: OrderValidateService,
    private val orderRepository: OrderRepository
) {

    fun requestOrder(orderRequestCommand: OrderRequestCommand) {
        val orderRequest = orderRequestCommand.toOrderRequest()
        orderRequest.validate(orderValidateService)
        orderRepository.save(orderRequest)
    }
}
