package com.sorsix.barmanagmentapi.repository

import com.sorsix.barmanagmentapi.domain.Table
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TableRepository : JpaRepository<Table, Long> {
}