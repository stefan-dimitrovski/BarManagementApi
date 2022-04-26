package com.sorsix.barmanagmentapi.service

import com.sorsix.barmanagmentapi.domain.Table
import com.sorsix.barmanagmentapi.repository.TableRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class TableService(private val tableRepository: TableRepository) {

    private val logger = LoggerFactory.getLogger(TableService::class.java)

    fun getTables(): List<Table> = tableRepository.findAll()

    fun getTableById(id: Long): Table? = tableRepository.getById(id)
//
//    @Transactional
//    fun updateIsOpen(tableId: Long, waiterId: Long) {
//        tableRepository.updateTable(tableId, waiterId)
//    }
}
