package com.sorsix.barmanagmentapi.repository

import com.sorsix.barmanagmentapi.domain.DrinkInOrder
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface DrinkInOrderRepository : JpaRepository<DrinkInOrder, Long> {


    fun findByOrderIdAndDrinkId(orderId: Long, drinkId: Long): DrinkInOrder?

    @Modifying
    @Query("Update DrinkInOrder d set d.quantity=:quantity where d.id=:drinkInOrderId")
    fun updateQuantity(drinkInOrderId: Long, quantity: Int)

}