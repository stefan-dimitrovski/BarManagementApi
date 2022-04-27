package com.sorsix.barmanagmentapi.service

import com.sorsix.barmanagmentapi.domain.DrinkInOrder
import com.sorsix.barmanagmentapi.repository.DrinkInOrderRepository
import com.sorsix.barmanagmentapi.repository.DrinkRepository
import com.sorsix.barmanagmentapi.repository.OrderRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class DrinkInOrderService(
    private val drinkInOrderRepository: DrinkInOrderRepository,
    private val drinkRepository: DrinkRepository,
    private val orderRepository: OrderRepository
) {
    private val logger = LoggerFactory.getLogger(DrinkInOrderService::class.java)


    fun findByOrderAndDrinkId(orderId: Long, drinkId: Long) =
        drinkInOrderRepository.findByOrderIdAndDrinkId(orderId, drinkId)


    fun findAllDrinksInOrder(orderId: Long) = drinkInOrderRepository.findAllByOrderId(orderId)


    fun createDrinkInOrder(orderId: Long, drinkId: Long, quantity: Int): DrinkInOrder {
        val order = orderRepository.getById(orderId)
        val drink = drinkRepository.getById(drinkId)
        logger.info("Saving drink in order!")
        return drinkInOrderRepository.save(DrinkInOrder(order = order, drink = drink, quantity = quantity))
//        this.findByOrderAndDrinkId(orderId, drinkId)?.let {
//            logger.info("Drink already in order: $it")
//            return it
//        } ?: kotlin.run {
//            val order = orderRepository.getById(orderId)
//            val drink = drinkRepository.getById(drinkId)
//            logger.info("Saving drink in order!")
//            return drinkInOrderRepository.save(DrinkInOrder(order = order, drink = drink, quantity = quantity))
//        }
    }

}