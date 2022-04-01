package com.sorsix.barmanagmentapi.api

import com.sorsix.barmanagmentapi.service.OrderService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/orders")
class OrderController(val orderService: OrderService) {


    @GetMapping
    fun getOrders() = orderService.getAllOrders()

}