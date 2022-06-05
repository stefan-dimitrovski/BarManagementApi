package com.sorsix.barmanagmentapi.api

import com.sorsix.barmanagmentapi.domain.Locale
import com.sorsix.barmanagmentapi.service.LocaleService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/locales")
@CrossOrigin
class LocaleController(val localeService: LocaleService) {

    @GetMapping
    fun getLocales(): List<Locale> = localeService.getAllLocales()
}
