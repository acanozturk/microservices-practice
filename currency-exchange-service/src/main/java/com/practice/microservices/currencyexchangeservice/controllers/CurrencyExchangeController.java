package com.practice.microservices.currencyexchangeservice.controllers;

import com.practice.microservices.currencyexchangeservice.api.responses.CurrencyExchangeResponse;
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
    public CurrencyExchangeResponse getConversionRate(@PathVariable final String from, @PathVariable final String to) {
        final CurrencyExchange currencyExchange = currencyExchangeService.getConversionRate(from, to);

        final CurrencyExchangeResponse response = new CurrencyExchangeResponse();

        response.setCurrencyExchange(currencyExchange);

        return response;
    }
}
