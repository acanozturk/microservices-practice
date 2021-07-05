package com.practice.microservices.currencyconversionservice.services.implementations;

import com.practice.microservices.currencyconversionservice.models.CurrencyConversion;
import com.practice.microservices.currencyconversionservice.proxies.CurrencyExchangeProxy;
import com.practice.microservices.currencyconversionservice.services.interfaces.CurrencyConversionService;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

    private final CurrencyExchangeProxy currencyExchangeProxy;

    @Override
    public CurrencyConversion convertCurrencies(final String from, final String to, final Double amount) {
        final CurrencyConversion currencyConversion = callCurrencyExchangeService(from, to);

        return fillCurrencyConversionResponse(amount, currencyConversion);
    }

    @Retry(name = "currency-exchange" /*fallbackMethod = "fallbackResponse"*/)
    private CurrencyConversion callCurrencyExchangeService(final String from, final String to) {

        return currencyExchangeProxy.getConversionRate(from, to);
    }

//    private String fallbackResponse(final Exception exception) {
//
//        return "Fallback error";
//    }

    private CurrencyConversion fillCurrencyConversionResponse(final Double amount,
            final CurrencyConversion currencyConversion) {

        final CurrencyConversion conversion = new CurrencyConversion();

        conversion.setId(currencyConversion.getId());
        conversion.setFrom(currencyConversion.getFrom());
        conversion.setTo(currencyConversion.getTo());
        conversion.setConversionRate(currencyConversion.getConversionRate());
        conversion.setAmount(amount);
        conversion.setConvertedAmount(amount * conversion.getConversionRate());
        conversion.setEnvironment(currencyConversion.getEnvironment());

        return conversion;
    }
}
