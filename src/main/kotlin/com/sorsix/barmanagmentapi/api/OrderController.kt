package com.sorsix.barmanagmentapi.api

import com.sorsix.barmanagmentapi.api.requests.OrderRequest
import com.sorsix.barmanagmentapi.domain.Order
import com.sorsix.barmanagmentapi.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/api/tables/{tableId}/orders")
class OrderController(val orderService: OrderService) {

    @GetMapping
    fun getOrderByTableId(@PathVariable tableId: Long) = orderService.getOrderByTableId(tableId)

    @PostMapping()
    fun createOrder(
        @RequestBody orderRequest: OrderRequest,
        @PathVariable tableId: Long,
    ): ResponseEntity<Order> = orderService.openOrder(tableId, orderRequest.waiterId).let {
        ResponseEntity.ok(it)
    }

    @PutMapping("/{id}")
    fun closeOrder(
        @PathVariable tableId: Long, @PathVariable id: Long
    ) = orderService.closeOrder(id)
}
