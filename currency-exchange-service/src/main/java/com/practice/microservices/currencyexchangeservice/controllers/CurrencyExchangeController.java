package com.practice.microservices.currencyexchangeservice.controllers;

import com.practice.microservices.currencyexchangeservice.dtos.CurrencyExchange;
import com.practice.microservices.currencyexchangeservice.services.interfaces.CurrencyExchangeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class CurrencyExchangeController {

    private final CurrencyExchangeService currencyExchangeService;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getConversionRate(@PathVariable final String from, @PathVariable final String to) {
        log.info("currency-exchange-service-getConversionRate() is called with {} and {}.", from, to);

        return currencyExchangeService.getCurrencyConversion(from, to);
    }

}
