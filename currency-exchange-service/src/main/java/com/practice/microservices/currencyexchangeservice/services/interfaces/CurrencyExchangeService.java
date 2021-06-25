package com.practice.microservices.currencyexchangeservice.services.interfaces;

import com.practice.microservices.currencyexchangeservice.dtos.CurrencyExchange;

public interface CurrencyExchangeService {

    CurrencyExchange getConversionRate(String from, String to);

}
