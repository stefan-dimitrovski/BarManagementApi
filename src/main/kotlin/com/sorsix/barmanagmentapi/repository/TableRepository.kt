package com.sorsix.barmanagmentapi.repository

import com.sorsix.barmanagmentapi.domain.Table
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TableRepository : JpaRepository<Table, Long> {

    @Modifying
    @Query("update Table t set t.isOpen = :isOpen where t.id = :tableId")
    fun updateIsOpen(tableId: Long, isOpen: Boolean)
}