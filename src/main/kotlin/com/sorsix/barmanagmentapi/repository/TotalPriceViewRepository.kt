package com.sorsix.barmanagmentapi.repository

import com.sorsix.barmanagmentapi.domain.views.TotalPriceVIew
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TotalPriceViewRepository : JpaRepository<TotalPriceVIew, Long> {

    @Query("SELECT view.totalPrice FROM TotalPriceVIew view WHERE view.orderId=:orderId")
    fun getTotalPriceByOrderId(orderId: Long): Double?
}