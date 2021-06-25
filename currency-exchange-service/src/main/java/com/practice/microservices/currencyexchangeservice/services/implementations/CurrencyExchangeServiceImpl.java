package com.practice.microservices.currencyexchangeservice.services.implementations;

import com.practice.microservices.currencyexchangeservice.dtos.CurrencyExchange;
import com.practice.microservices.currencyexchangeservice.entities.CurrencyExchangeEntity;
import com.practice.microservices.currencyexchangeservice.repositories.CurrencyExchangeRepository;
import com.practice.microservices.currencyexchangeservice.services.interfaces.CurrencyExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    private final CurrencyExchangeRepository currencyExchangeRepository;
    private final Environment environment;

    @Override
    public CurrencyExchange getCurrencyConversion(final String from, final String to) {
        final CurrencyExchangeEntity currencyExchangeEntity =
                currencyExchangeRepository.findCurrencyExchangeEntityByFromAndTo(from, to);

        return fillCurrencyExchangeResponse(currencyExchangeEntity);
    }

    private CurrencyExchange fillCurrencyExchangeResponse(final CurrencyExchangeEntity exchangeEntity) {
        final CurrencyExchange exchange = new CurrencyExchange();

        exchange.setId(exchangeEntity.getId());
        exchange.setFrom(exchangeEntity.getFrom());
        exchange.setTo(exchangeEntity.getTo());
        exchange.setConversionRate(exchangeEntity.getConversionRate());
        exchange.setEnvironment(getCurrentEnvironment());

        return exchange;
    }

    private String getCurrentEnvironment() {

        return environment.getProperty("local.server.port");
    }
}
