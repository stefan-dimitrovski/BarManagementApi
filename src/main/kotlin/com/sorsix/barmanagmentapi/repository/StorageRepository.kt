package com.sorsix.barmanagmentapi.repository

import com.sorsix.barmanagmentapi.domain.Storage
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StorageRepository : JpaRepository<Storage, Long> {

    fun findByDrinkIdAndLocaleId(drinkId: Long, localeId: Long) : Storage?
}
