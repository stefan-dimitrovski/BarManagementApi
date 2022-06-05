package com.sorsix.barmanagmentapi.service

import com.sorsix.barmanagmentapi.repository.StorageRepository
import org.springframework.stereotype.Service

@Service
class StorageService(private val storageRepository: StorageRepository) {
}