package com.sorsix.barmanagmentapi.repository

import com.sorsix.barmanagmentapi.domain.DrinksInOrder
import com.sorsix.barmanagmentapi.domain.Storage
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface DrinksInOrderRepository : JpaRepository<DrinksInOrder, Long> {

    fun findByDrinkIdAndOrderId(drinkId: Long, orderId: Long) : DrinksInOrder?
}