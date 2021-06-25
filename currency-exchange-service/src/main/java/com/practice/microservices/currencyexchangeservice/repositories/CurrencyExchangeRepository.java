package com.practice.microservices.currencyexchangeservice.repositories;

import com.practice.microservices.currencyexchangeservice.entities.CurrencyExchangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeEntity, Long> {

    CurrencyExchangeEntity findCurrencyExchangeEntityByFromAndTo(String from, String to);
}
