package com.practice.microservices.currencyexchangeservice.services.implementations;

import com.practice.microservices.currencyexchangeservice.data.CurrencyExchange;
import com.practice.microservices.currencyexchangeservice.services.interfaces.CurrencyExchangeService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    @Override
    public CurrencyExchange getConversionRate(final String from, final String to) {
        final CurrencyExchange exchange = new CurrencyExchange();

        exchange.setId(ThreadLocalRandom.current().nextLong(1, 10000));
        exchange.setFrom(from);
        exchange.setTo(to);
        exchange.setConversionRate(BigDecimal.valueOf(8.67));

        return exchange;
    }

}
