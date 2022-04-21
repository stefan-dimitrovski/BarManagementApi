package com.sorsix.barmanagmentapi.api

import com.sorsix.barmanagmentapi.api.requests.CreateLocaleRequest
import com.sorsix.barmanagmentapi.domain.Locale
import com.sorsix.barmanagmentapi.service.LocaleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
