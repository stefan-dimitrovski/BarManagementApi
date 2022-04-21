package com.sorsix.barmanagmentapi.repository

import com.sorsix.barmanagmentapi.domain.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface OrderRepository : JpaRepository<Order, Long> {

    fun getOrderByTableId(tableId: Long): Order?

    @Modifying
    @Query("update Order o set o.closedAt = :time where o.id = :orderId")
    fun updateClosedAt(orderId: Long, time: LocalDateTime = LocalDateTime.now())


    fun getAllByTableIdAndWaiterId(tableId: Long, waiterId: Long)
}
