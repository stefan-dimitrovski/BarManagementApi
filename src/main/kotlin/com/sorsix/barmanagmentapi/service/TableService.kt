package com.sorsix.barmanagmentapi.service

import com.sorsix.barmanagmentapi.domain.Table
import com.sorsix.barmanagmentapi.repository.TableRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class TableService(private val tableRepository: TableRepository) {

    fun getTables(): List<Table> = tableRepository.findAll()

    fun getTableById(id: Long): Table? = tableRepository.getById(id)

    @Transactional
    fun updateIsOpen(tableId: Long, isOpen: Boolean) {
        tableRepository.updateIsOpen(tableId, isOpen)
    }
}
