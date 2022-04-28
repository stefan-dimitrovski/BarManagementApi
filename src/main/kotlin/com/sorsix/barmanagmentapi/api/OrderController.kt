package com.sorsix.barmanagmentapi.api

import com.sorsix.barmanagmentapi.api.requests.DrinkInOrderRequest
import com.sorsix.barmanagmentapi.api.requests.OrderIdAndDrinkIdRequest
import com.sorsix.barmanagmentapi.api.requests.OrderRequest
import com.sorsix.barmanagmentapi.api.response.*
import com.sorsix.barmanagmentapi.domain.DrinkInOrder
import com.sorsix.barmanagmentapi.domain.Order
import com.sorsix.barmanagmentapi.domain.results.OrderViewFailed
import com.sorsix.barmanagmentapi.domain.results.OrderViewOk
import com.sorsix.barmanagmentapi.service.DrinkInOrderService
import com.sorsix.barmanagmentapi.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/api/tables/{tableId}/orders")
class OrderController(
    private val orderService: OrderService,
    private val drinkInOrderService: DrinkInOrderService,
) {

    @GetMapping
    fun getOrderByTableId(@PathVariable tableId: Long) = orderService.getOrderByTableId(tableId)

    @GetMapping("/get-order")
    fun getOrder(@PathVariable tableId: Long, @RequestParam(name = "id") orderId: Long): Order? =
        orderService.findOrderById(orderId)

    @PostMapping("/create-order")
    fun createOrder(
        @RequestBody request: OrderRequest,
        @PathVariable tableId: Long,
    ): ResponseEntity<OrderResponse> = orderService.getActiveOrderByTableIdAndWaiterId(tableId, request.waiterId)?.let {
        ResponseEntity.ok(
            OrderAlreadyExists("Order already open. Please close the ongoing order first", it)
        )
    } ?: kotlin.run {
        return ResponseEntity.ok(
            OrderOk(
                "Order successfully created!", orderService.openOrder(tableId, request.waiterId)
            )
        )
    }

    @PutMapping("/{id}")
    fun closeOrder(
        @PathVariable tableId: Long, @PathVariable id: Long
    ) = orderService.closeOrder(id)


    @PostMapping("/add-drink")
    fun addDrinkToOrder(
        @RequestBody request: DrinkInOrderRequest, @PathVariable tableId: String
    ): ResponseEntity<DrinkInOrder> =
        ResponseEntity.ok(orderService.addDrinkToOrder(orderId = request.orderId, drinkId = request.drinkId))


    @GetMapping("/orderId")
    fun findByOrderAndDrinkId(
        @RequestBody request: OrderIdAndDrinkIdRequest, @PathVariable tableId: String
    ): ResponseEntity<DrinkInOrder> =
        ResponseEntity.ok(drinkInOrderService.findByOrderAndDrinkId(request.orderId, request.drinkId))

    @GetMapping("/order")
    fun findAllDrinksInOrder(
        @RequestParam(name = "id") orderId: Long, @PathVariable tableId: String,
    ): List<DrinkInOrder> = drinkInOrderService.findAllDrinksInOrder(orderId)


    @PostMapping("/save-drinkInOrder")
    fun saveDrinkInOrder(
        @RequestBody request: OrderIdAndDrinkIdRequest, @PathVariable tableId: String
    ): ResponseEntity<DrinkInOrderResponse> {
        drinkInOrderService.findByOrderAndDrinkId(request.orderId, request.drinkId)?.let {
            return ResponseEntity.badRequest().body(DrinkInOrderAlreadyExists("Drink already exists in order!", it))
        } ?: kotlin.run {
            return ResponseEntity.ok(
                DrinkInOrderOk(
                    drinkInOrderService.createDrinkInOrder(
                        request.orderId, request.drinkId, request.quantity
                    )
                )
            )
        }
    }

    @GetMapping("/order-info")
    fun getOrderInfo(
        @RequestParam(name = "id") orderId: Long, @PathVariable tableId: String,
    ): OrderViewResponse? {
        val result = this.orderService.getOrderInfo(orderId)
        return when (result) {
            is OrderViewOk -> OrderViewResponse(result.orderViewList, result.totalSum)
            is OrderViewFailed -> null
        }
    }


}
