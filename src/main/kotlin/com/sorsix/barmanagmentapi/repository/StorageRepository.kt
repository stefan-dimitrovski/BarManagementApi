package com.sorsix.barmanagmentapi.repository

import com.sorsix.barmanagmentapi.domain.Storage
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface StorageRepository : JpaRepository<Storage, Long> {

    @Query("update Storage s set s.quantity=:quantity where s.locale.id=:localeId and s.drink.id=:drinkId")
    fun updateStorageQuantity(localeId: Long, drinkId: Long, quantity: Int)

}