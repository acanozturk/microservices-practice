package com.practice.microservices.currencyexchangeservice.bootloader;

import com.practice.microservices.currencyexchangeservice.entities.CurrencyExchangeEntity;
import com.practice.microservices.currencyexchangeservice.repositories.CurrencyExchangeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@AllArgsConstructor
@Slf4j
public class Bootloader implements CommandLineRunner {

    private final CurrencyExchangeRepository currencyExchangeRepository;

    @Override
    public void run(String... args) throws RuntimeException {
        bootLoader();
        log.info("Bootloader successful.");
    }

    private void bootLoader() {
        final Set<CurrencyExchangeEntity> exchangeEntitySet = new HashSet<>();

        final CurrencyExchangeEntity exchangeEntity1 = new CurrencyExchangeEntity();
        final CurrencyExchangeEntity exchangeEntity2 = new CurrencyExchangeEntity();
        final CurrencyExchangeEntity exchangeEntity3 = new CurrencyExchangeEntity();

        exchangeEntity1.setFrom("USD");
        exchangeEntity1.setTo("EURO");
        exchangeEntity1.setConversionRate(0.8380);
        exchangeEntitySet.add(exchangeEntity1);

        exchangeEntity2.setFrom("USD");
        exchangeEntity2.setTo("POUND");
        exchangeEntity2.setConversionRate(0.7170);
        exchangeEntitySet.add(exchangeEntity2);

        exchangeEntity3.setFrom("USD");
        exchangeEntity3.setTo("TL");
        exchangeEntity3.setConversionRate(8.6528);
        exchangeEntitySet.add(exchangeEntity3);

        currencyExchangeRepository.saveAll(exchangeEntitySet);
    }
}
