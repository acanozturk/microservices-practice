package com.practice.microservices.currencyconversionservice.controllers;

import com.practice.microservices.currencyconversionservice.models.CurrencyConversion;
import com.practice.microservices.currencyconversionservice.services.interfaces.CurrencyConversionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CurrencyConversionController {

    private final CurrencyConversionService currencyConversionService;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/amount/{amount}")
    public CurrencyConversion getConversionRate(@PathVariable final String from, @PathVariable final String to,
            @PathVariable final Double amount) {

       return currencyConversionService.convertCurrencies(from, to, amount);
    }
}
