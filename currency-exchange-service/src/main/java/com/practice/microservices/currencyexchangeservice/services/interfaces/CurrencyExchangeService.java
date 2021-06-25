package com.practice.microservices.currencyexchangeservice.services.interfaces;

import com.practice.microservices.currencyexchangeservice.data.CurrencyExchange;

public interface CurrencyExchangeService {

    CurrencyExchange getConversionRate(String from, String to);

}
