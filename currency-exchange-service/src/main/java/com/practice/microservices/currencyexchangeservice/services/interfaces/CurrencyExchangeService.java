package com.practice.microservices.currencyexchangeservice.services.interfaces;

import com.practice.microservices.currencyexchangeservice.dtos.CurrencyExchange;

public interface CurrencyExchangeService {

    CurrencyExchange getCurrencyConversion(String from, String to);

}
