package com.practice.microservices.currencyexchangeservice.dtos;

import lombok.Data;

@Data
public class CurrencyExchange {

    private Long id;
    private String from;
    private String to;
    private Double conversionRate;
    private String environment;
}
