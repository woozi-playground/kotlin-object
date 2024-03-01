package org.woozi.practice.laborder.order.adapter.out.http

import org.springframework.stereotype.Component
import java.net.http.HttpClient

@Component
class MenuClient(
    private val httpClient: HttpClient = HttpClient.newHttpClient()
) {
    fun getByIds(menuIds: List<Long>): List<MenuResponse> {
        TODO("Not yet implemented")
    }
}