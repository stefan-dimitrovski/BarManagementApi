package com.sorsix.barmanagmentapi.service

import com.sorsix.barmanagmentapi.domain.DrinkInOrder
import com.sorsix.barmanagmentapi.domain.Order
import com.sorsix.barmanagmentapi.domain.results.*
import com.sorsix.barmanagmentapi.repository.*
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val tableRepository: TableRepository,
    private val authRepository: AuthRepository,
    private val drinkRepository: DrinkRepository,
    private val drinkInOrderRepository: DrinkInOrderRepository,

    ) {

    fun getAllOrders(): List<Order> = orderRepository.findAll()

    fun findOrderById(id: Long): Order? =
        orderRepository.findById(id).orElseGet(null)

    fun getOrderByTableId(tableId: Long): Order? = orderRepository.getOrderByTableId(tableId)

    @Transactional
    fun openOrder(tableId: Long, waiterId: Long): Order {
        val table = tableRepository.findById(tableId).get()
        val waiter = authRepository.findById(waiterId).get()
        val order = Order(table = table, waiter = waiter) // ,drinks= listOf()
        tableRepository.updateTable(tableId, waiterId)
        return orderRepository.save(order)
    }

    fun closeOrder(orderId: Long) =
        this.findOrderById(orderId)?.let {
            orderRepository.updateClosedAt(orderId)
            tableRepository.updateTable(it.table.id, null)
        }


    fun addDrinkToOrder(orderId: Long, drinkId: Long): DrinkInOrder {
        val order = orderRepository.getById(orderId)
        val drink = drinkRepository.getById(drinkId)
        return drinkInOrderRepository.save(DrinkInOrder(order = order, drink = drink))
    }

    @Transactional
    fun updateQuantityForDrinkInOrder(orderId: Long, drinkId: Long, quantity: Int): DrinkInOrderResult =
        drinkInOrderRepository.findByOrderIdAndDrinkId(orderId, drinkId)?.let {
            drinkInOrderRepository.updateQuantity(it.id, quantity)
            DrinkInOrderSuccess
        } ?: DrinkInOrderNotFound


}
