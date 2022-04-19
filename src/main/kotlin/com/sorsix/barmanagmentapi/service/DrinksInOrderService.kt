package com.sorsix.barmanagmentapi.service

import com.sorsix.barmanagmentapi.repository.DrinkRepository
import com.sorsix.barmanagmentapi.repository.OrderRepository
import com.sorsix.barmanagmentapi.repository.StorageRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class DrinksInOrderService(
    private val orderRepository: OrderRepository,
    private val drinkRepository: DrinkRepository,
    private val storageRepository: StorageRepository
) {

    @Transactional
    fun addDrinkToOrder(drinkId: Long, orderId: Long, quantity: Int) {
        val drink = drinkRepository.getById(drinkId)
        val order = orderRepository.getOrderById(orderId)
        val localeId = order?.table?.waiter?.worksInLocale

//        order
//        storageRepository.updateStorageQuantity(localeId,)


    }

}