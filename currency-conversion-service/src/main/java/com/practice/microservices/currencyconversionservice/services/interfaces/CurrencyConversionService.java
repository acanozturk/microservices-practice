package com.practice.microservices.currencyconversionservice.services.interfaces;

import com.practice.microservices.currencyconversionservice.models.CurrencyConversion;

public interface CurrencyConversionService {

    CurrencyConversion getCurrencyConversion(String from, String to, Double amount);
}
