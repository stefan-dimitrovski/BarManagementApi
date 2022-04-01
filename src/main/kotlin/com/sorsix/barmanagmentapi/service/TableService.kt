package com.sorsix.barmanagmentapi.service

import com.sorsix.barmanagmentapi.repository.TableRepository
import org.springframework.stereotype.Service

@Service
class TableService(val tableRepository: TableRepository) {
}