package com.sorsix.barmanagmentapi.service

import com.sorsix.barmanagmentapi.domain.Order
import com.sorsix.barmanagmentapi.repository.OrderRepository
import com.sorsix.barmanagmentapi.repository.TableRepository
import com.sorsix.barmanagmentapi.repository.UserRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class OrderService(
    val orderRepository: OrderRepository,
    val tableRepository: TableRepository,
    val userRepository: UserRepository
) {

    fun getAllOrders(): List<Order> = orderRepository.findAll()

    fun findOrderById(id: Long): Order? =
        orderRepository.findById(id).orElseGet(null)

    fun openOrder(tableId: Long, waiterId: Long): Order {
        val table = tableRepository.findById(tableId).get()
        table.isOpen = false
        val waiter = userRepository.findById(waiterId).get()
        val order = Order(table = table, waiter = waiter)
        return orderRepository.save(order)
    }

    fun closeOrder(orderId: Long): Order {
        val order = findOrderById(orderId)!!
        order.table.isOpen = true
        order.closedAt = LocalDateTime.now()
        return order
    }

}