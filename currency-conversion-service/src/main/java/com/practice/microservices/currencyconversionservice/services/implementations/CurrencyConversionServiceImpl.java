package com.practice.microservices.currencyconversionservice.services.implementations;

import com.practice.microservices.currencyconversionservice.models.CurrencyConversion;
import com.practice.microservices.currencyconversionservice.services.interfaces.CurrencyConversionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
@AllArgsConstructor
@Slf4j
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

    @Override
    public CurrencyConversion getCurrencyConversion(final String from, final String to, final Double amount) {
        final HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        final CurrencyConversion currencyConversion = callExchangeService(uriVariables);

        return fillCurrencyConversionResponse(amount, currencyConversion);
    }

    private CurrencyConversion callExchangeService(final HashMap<String, String> uriVariables) {

        return new RestTemplate()
                .getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                        CurrencyConversion.class, uriVariables)
                .getBody();
    }

    private CurrencyConversion fillCurrencyConversionResponse(final Double amount, final CurrencyConversion currencyConversion) {
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
