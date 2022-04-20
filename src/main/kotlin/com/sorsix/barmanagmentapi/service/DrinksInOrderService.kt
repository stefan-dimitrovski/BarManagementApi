//package com.sorsix.barmanagmentapi.service
//
//import com.sorsix.barmanagmentapi.domain.DrinksInOrder
//import com.sorsix.barmanagmentapi.domain.results.DrinkNotFound
//import com.sorsix.barmanagmentapi.domain.results.DrinksInOrderResult
//import com.sorsix.barmanagmentapi.domain.results.LocaleNotFound
//import com.sorsix.barmanagmentapi.domain.results.OrderNotFound
//import com.sorsix.barmanagmentapi.dto.DrinksInOrderRequest
//import com.sorsix.barmanagmentapi.repository.*
//import org.springframework.stereotype.Service
//import javax.transaction.Transactional
//
//@Service
//class DrinksInOrderService(
//    private val orderRepository: OrderRepository,
//    private val drinkRepository: DrinkRepository,
//    private val drinksInOrderRepository: DrinksInOrderRepository,
//    private val localeRepository: LocaleRepository
//) {
//
//    @Transactional
//    fun addDrinkToOrder(drinksInOrderRequest: DrinksInOrderRequest): DrinksInOrderResult {
//        val drinkId = drinksInOrderRequest.drinkId
//        val orderId = drinksInOrderRequest.orderId
//        val localeId = drinksInOrderRequest.localeId
//        val quantity = drinksInOrderRequest.quantity
//
//        localeRepository.getLocaleById(localeId)?.let { locale ->
//            {
//                drinkRepository.getDrinkById(drinkId)?.let { drink ->
//                    {
//                        orderRepository.getOrderById(orderId)?.let { order ->
//                            {
//                                drinksInOrderRepository.findByDrinkIdAndOrderId(drinkId,orderId)?.let {
//
//                                }
//                                DrinksInOrderResult(
//                                    drinksInOrderRepository.save(
//                                        DrinksInOrder(
//                                            drink = drink,
//                                            order = order,
//                                            quantity = quantity,
//                                            locale = locale
//                                        )
//                                    )
//                                )
//                            }
//                        } ?: OrderNotFound
//                    }
//                } ?: DrinkNotFound
//            }
//        } ?: LocaleNotFound
//
//
//    }
//
//
//}
