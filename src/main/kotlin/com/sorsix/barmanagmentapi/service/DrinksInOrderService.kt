package com.sorsix.barmanagmentapi.service

import com.sorsix.barmanagmentapi.domain.DrinksInOrder
import com.sorsix.barmanagmentapi.dto.DrinksInOrderRequest
import com.sorsix.barmanagmentapi.repository.*
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class DrinksInOrderService(
    private val orderRepository: OrderRepository,
    private val drinkRepository: DrinkRepository,
    private val drinksInOrderRepository: DrinksInOrderRepository,
    private val localeRepository: LocaleRepository
) {

    @Transactional
    fun addDrinkToOrder(drinksInOrderRequest: DrinksInOrderRequest) {
        val drinkId = drinksInOrderRequest.drinkId
        val orderId = drinksInOrderRequest.orderId
        val localeId = drinksInOrderRequest.localeId
        val quantity = drinksInOrderRequest.quantity

        drinksInOrderRepository.findByDrinkIdAndOrderId(drinkId, orderId)?.let { drinkInOrder ->
            {
                drinkRepository.getDrinkById(drinkInOrder.drink.id)?.let { drink ->
                    {
                        localeRepository.getLocaleById(localeId)?.let { locale ->
                            {
                                orderRepository.getOrderById(orderId)?.let { order ->
                                    {
                                        drinksInOrderRepository.save(
                                            DrinksInOrder(
                                                drink = drink,
                                                order = order,
                                                quantity = quantity,
                                                locale = locale
                                            )
                                        )
                                    }
                                }

                            }

                        }
                    }
                }
            }


        }


    }

}