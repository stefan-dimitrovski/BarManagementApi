package com.sorsix.barmanagmentapi.api

import com.sorsix.barmanagmentapi.api.requests.CreateLocaleRequest
import com.sorsix.barmanagmentapi.domain.Locale
import com.sorsix.barmanagmentapi.service.LocaleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/locales")
@CrossOrigin
class LocaleController(val localeService: LocaleService) {

    @GetMapping
    fun getLocales() = localeService.getAllLocales()

    @PostMapping("/create")
    fun createArticle(@RequestBody request: CreateLocaleRequest): ResponseEntity<Locale> =
        ResponseEntity.ok(localeService.createLocale(request))
}
