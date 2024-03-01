package org.woozi.practice.laborder.shop.adapter.`in`

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.woozi.practice.laborder.shop.application.ShopMenuBoardQueryService
import org.woozi.practice.laborder.shop.domain.MenuBoard

@RestController
class ShopMenuApi(
    private val shopMenuBoardQueryService: ShopMenuBoardQueryService
) {
    @GetMapping("/shops/{shopId}/menu-board")
    fun findMenuBoard(@PathVariable shopId: Long): ResponseEntity<MenuBoard> {
        val menuBoard = shopMenuBoardQueryService.findMenuBoard(shopId)
        return ResponseEntity.ok().body(menuBoard)
    }
}