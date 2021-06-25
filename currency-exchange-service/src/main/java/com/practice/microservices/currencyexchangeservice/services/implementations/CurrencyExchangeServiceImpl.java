package com.practice.microservices.currencyexchangeservice.services.implementations;

import com.practice.microservices.currencyexchangeservice.data.CurrencyExchange;
import com.practice.microservices.currencyexchangeservice.services.interfaces.CurrencyExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
@AllArgsConstructor
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    private final Environment environment;

    @Override
    public CurrencyExchange getConversionRate(final String from, final String to) {
        final CurrencyExchange exchange = new CurrencyExchange();

        exchange.setId(getRandomId());
        exchange.setFrom(from);
        exchange.setTo(to);
        exchange.setConversionRate(getRandomConversionRate());
        exchange.setEnvironment(getCurrentEnvironment());

        return exchange;
    }

    private long getRandomId() {

        return ThreadLocalRandom.current().nextLong(1, 10000);
    }

    private double getRandomConversionRate() {

        return ThreadLocalRandom.current().nextDouble(1, 10);
    }

    private String getCurrentEnvironment() {

        return environment.getProperty("local.server.port");
    }
}
