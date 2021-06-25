package com.practice.microservices.currencyconversionservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversion {

    private Long id;
    private String from;
    private String to;
    private Double amount;
    private Double conversionRate;
    private Double convertedAmount;
    private String environment;

}
