package com.practice.microservices.currencyexchangeservice.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchange {

    private long id;
    private String from;
    private String to;
    private double conversionRate;
    private String environment;
}
