package com.practice.microservices.currencyexchangeservice.api.responses;

import com.practice.microservices.currencyexchangeservice.dtos.CurrencyExchange;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CurrencyExchangeResponse extends BaseResponse {

    private CurrencyExchange currencyExchange;
}
