package com.practice.microservices.currencyexchangeservice.controllers;

import com.practice.microservices.currencyexchangeservice.dtos.CurrencyExchange;
import com.practice.microservices.currencyexchangeservice.services.interfaces.CurrencyExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CurrencyExchangeController {

    private final CurrencyExchangeService currencyExchangeService;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getConversionRate(@PathVariable final String from, @PathVariable final String to) {

        return currencyExchangeService.getConversionRate(from, to);


    }
}
