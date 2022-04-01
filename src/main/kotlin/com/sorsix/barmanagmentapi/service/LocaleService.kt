package com.sorsix.barmanagmentapi.service

import com.sorsix.barmanagmentapi.domain.Locale
import com.sorsix.barmanagmentapi.repository.LocaleRepository
import org.springframework.stereotype.Service

@Service
class LocaleService(val localeRepository: LocaleRepository) {

    fun getAllLocales(): List<Locale> = localeRepository.findAll()
}