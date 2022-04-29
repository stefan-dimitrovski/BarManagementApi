package com.sorsix.barmanagmentapi.api

import com.sorsix.barmanagmentapi.api.requests.UpdateDrinkInOrderRequest
import com.sorsix.barmanagmentapi.domain.DrinkInOrder
import com.sorsix.barmanagmentapi.domain.results.DrinkInOrderNotFound
import com.sorsix.barmanagmentapi.domain.results.DrinkInOrderSuccess
import com.sorsix.barmanagmentapi.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/api/orders/drink-in-order")
class DrinkInOrderController(
    private val orderService: OrderService
) {
    @PutMapping("/update-quantity")
    fun updateQuantityForDrinkInOrder(
        @RequestBody request: UpdateDrinkInOrderRequest
    ): ResponseEntity<DrinkInOrder?> {
        val drinkInOrderRes = orderService.updateQuantityForDrinkInOrder(
            drinkIdInOrderId = request.drinkInOrderId, quantity = request.quantity
        )
        return when (drinkInOrderRes) {
            is DrinkInOrderSuccess -> ResponseEntity.ok(drinkInOrderRes.drinkInOrder)
            is DrinkInOrderNotFound -> ResponseEntity.badRequest().build()
        }
    }
}