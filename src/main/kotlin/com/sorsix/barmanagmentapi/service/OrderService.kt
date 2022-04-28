package com.sorsix.barmanagmentapi.service

import com.sorsix.barmanagmentapi.domain.DrinkInOrder
import com.sorsix.barmanagmentapi.domain.Order
import com.sorsix.barmanagmentapi.domain.results.*
import com.sorsix.barmanagmentapi.repository.*
import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val tableRepository: TableRepository,
    private val authRepository: AuthRepository,
    private val drinkRepository: DrinkRepository,
    private val drinkInOrderRepository: DrinkInOrderRepository,
    private val activeOrdersPerWaiterRepository: ActiveOrdersPerWaiterRepository,
    private val orderViewRepository: OrderViewRepository

) {
    private val logger = LoggerFactory.getLogger(OrderService::class.java)


    fun findOrderById(id: Long): Order? = orderRepository.findById(id).orElseGet(null)

    fun getOrderByTableId(tableId: Long): Order? = orderRepository.getOrderByTableId(tableId)

    fun getActiveOrderByTableIdAndWaiterId(tableId: Long, waiterId: Long): Order? {
        activeOrdersPerWaiterRepository.findByTableIdAndWaiterId(tableId, waiterId)?.let {
            val activeOrder = it.filter { orders -> orders.closedAt == null }
            if (activeOrder.isNotEmpty()) {
                logger.info("FOUND OPENED ORDER WITH tableId:$tableId and waiterId:$waiterId")
                return orderRepository.getById(activeOrder[0].orderId)
            } else {
                logger.warn("ORDER WITH tableId:$tableId and waiterId:$waiterId NOT FOUND. RETURNING NULL!")
                return null
            }
        } ?: return null
    }

    @Transactional
    fun openOrder(tableId: Long, waiterId: Long): Order {
        val table = tableRepository.findById(tableId).get()
        val waiter = authRepository.findById(waiterId).get()
        tableRepository.updateTable(tableId, waiterId)
        return orderRepository.save(Order(table = table, waiter = waiter))
    }


    fun closeOrder(orderId: Long) = this.findOrderById(orderId)?.let {
        orderRepository.updateClosedAt(orderId)
        tableRepository.updateTable(it.table.id, null)
    }


    fun addDrinkToOrder(orderId: Long, drinkId: Long): DrinkInOrder {
        val order = orderRepository.getById(orderId)
        val drink = drinkRepository.getById(drinkId)
        return drinkInOrderRepository.save(DrinkInOrder(order = order, drink = drink))
    }


    @Transactional
    fun updateQuantityForDrinkInOrder(drinkIdInOrderId: Long, quantity: Int): DrinkInOrderResult =
        drinkInOrderRepository.findByIdOrNull(drinkIdInOrderId)?.let {
            drinkInOrderRepository.updateQuantity(it.id, quantity)
            DrinkInOrderSuccess(it)
        } ?: DrinkInOrderNotFound

    fun getOrderInfo(orderId: Long): OrderViewResult =
        this.orderViewRepository.findByOrderId(orderId)?.let { view ->
            val totalPrice = view.sumOf { it.quantity * it.drinkPrice }.toDouble()
            OrderViewOk(view, totalPrice)
        } ?: OrderViewFailed


}