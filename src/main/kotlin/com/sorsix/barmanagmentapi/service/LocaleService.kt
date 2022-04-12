package com.sorsix.barmanagmentapi.service

import com.sorsix.barmanagmentapi.api.requests.CreateLocaleRequest
import com.sorsix.barmanagmentapi.domain.Locale
import com.sorsix.barmanagmentapi.repository.LocaleRepository
import org.springframework.stereotype.Service

@Service
class LocaleService(private val localeRepository: LocaleRepository) {

    fun getAllLocales(): List<Locale> = localeRepository.findAll()

    fun createLocale(localeReq: CreateLocaleRequest): Locale {
        return localeRepository.save(
            Locale(
                address = localeReq.address,
                lat = localeReq.lat,
                lng = localeReq.lng,
                name = localeReq.name,
                waiters = listOf()
            )
        )
    }
}
